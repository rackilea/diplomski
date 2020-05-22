import uno
from os.path import abspath, isfile, splitext
from com.sun.star.beans import PropertyValue
from com.sun.star.task import ErrorCodeIOException
from com.sun.star.connection import NoConnectException

FAMILY_TEXT = "Text"
FAMILY_SPREADSHEET = "Spreadsheet"
FAMILY_PRESENTATION = "Presentation"
FAMILY_DRAWING = "Drawing"
DEFAULT_OPENOFFICE_PORT = 8100

FILTER_MAP = {
    "pdf": {
        FAMILY_TEXT: "writer_pdf_Export",
        FAMILY_SPREADSHEET: "calc_pdf_Export",
        FAMILY_PRESENTATION: "impress_pdf_Export",
        FAMILY_DRAWING: "draw_pdf_Export"
    },
    "html": {
        FAMILY_TEXT: "HTML (StarWriter)",
        FAMILY_SPREADSHEET: "HTML (StarCalc)",
        FAMILY_PRESENTATION: "impress_html_Export"
    },
    "odt": { FAMILY_TEXT: "writer8" },
    "doc": { FAMILY_TEXT: "MS Word 97" },
    "rtf": { FAMILY_TEXT: "Rich Text Format" },
    "txt": { FAMILY_TEXT: "Text" },
    "docx": { FAMILY_TEXT: "MS Word 2007 XML" },
    "ods": { FAMILY_SPREADSHEET: "calc8" },
    "xls": { FAMILY_SPREADSHEET: "MS Excel 97" },
    "odp": { FAMILY_PRESENTATION: "impress8" },
    "ppt": { FAMILY_PRESENTATION: "MS PowerPoint 97" },
    "swf": { FAMILY_PRESENTATION: "impress_flash_Export" }
}

class DocumentConverter:

    def __init__(self, port=DEFAULT_OPENOFFICE_PORT):
        localContext = uno.getComponentContext()
        resolver = localContext.ServiceManager.createInstanceWithContext("com.sun.star.bridge.UnoUrlResolver", localContext)
        try:
            self.context = resolver.resolve("uno:socket,host=localhost,port=%s;urp;StarOffice.ComponentContext" % port)
        except NoConnectException:
            raise Exception, "failed to connect to OpenOffice.org on port %s" % port
        self.desktop = self.context.ServiceManager.createInstanceWithContext("com.sun.star.frame.Desktop", self.context)

    def convert(self, inputFile, outputFile):

        inputUrl = self._toFileUrl(inputFile)
        outputUrl = self._toFileUrl(outputFile)

        document = self.desktop.loadComponentFromURL(inputUrl, "_blank", 0, self._toProperties(Hidden=True))
        #document.setPropertyValue("DocumentTitle", "saf" ) TODO: Check how this can be set and set doc update mode to  FULL_UPDATE

        if self._detectFamily(document) == FAMILY_TEXT:
            indexes = document.getDocumentIndexes()
            for i in range(0, indexes.getCount()):
                index = indexes.getByIndex(i)
                index.update()

            try:
                document.refresh()
            except AttributeError:
                pass

            indexes = document.getDocumentIndexes()
            for i in range(0, indexes.getCount()):
                index = indexes.getByIndex(i)
                index.update()

        outputExt = self._getFileExt(outputFile)
        filterName = self._filterName(document, outputExt)

        try:
            document.storeToURL(outputUrl, self._toProperties(FilterName=filterName))
        finally:
            document.close(True)

    def _filterName(self, document, outputExt):
        family = self._detectFamily(document)
        try:
            filterByFamily = FILTER_MAP[outputExt]
        except KeyError:
            raise Exception, "unknown output format: '%s'" % outputExt
        try:
            return filterByFamily[family]
        except KeyError:
            raise Exception, "unsupported conversion: from '%s' to '%s'" % (family, outputExt)

    def _detectFamily(self, document):
        if document.supportsService("com.sun.star.text.GenericTextDocument"):
            # NOTE: a GenericTextDocument is either a TextDocument, a WebDocument, or a GlobalDocument
            # but this further distinction doesn't seem to matter for conversions
            return FAMILY_TEXT
        if document.supportsService("com.sun.star.sheet.SpreadsheetDocument"):
            return FAMILY_SPREADSHEET
        if document.supportsService("com.sun.star.presentation.PresentationDocument"):
            return FAMILY_PRESENTATION
        if document.supportsService("com.sun.star.drawing.DrawingDocument"):
            return FAMILY_DRAWING
        raise Exception, "unknown document family: %s" % document

    def _getFileExt(self, path):
        ext = splitext(path)[1]
        if ext is not None:
            return ext[1:].lower()

    def _toFileUrl(self, path):
        return uno.systemPathToFileUrl(abspath(path))

    def _toProperties(self, **args):
        props = []
        for key in args:
            prop = PropertyValue()
            prop.Name = key
            prop.Value = args[key]
            props.append(prop)
        return tuple(props)

if __name__ == "__main__":
    from sys import argv, exit

    if len(argv) < 3:
        print "USAGE: python %s <input-file> <output-file>" % argv[0]
        exit(255)
    if not isfile(argv[1]):
        print "no such input file: %s" % argv[1]
        exit(1)

    try:
        converter = DocumentConverter()    
        converter.convert(argv[1], argv[2])
    except Exception, exception:
        print "ERROR!" + str(exception)
        exit(1)