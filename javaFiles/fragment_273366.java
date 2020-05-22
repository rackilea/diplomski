import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ooxml.util.SAXHelper;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;

public class ExampleEventUserModel {

    public void processAllSheets(String filename) throws Exception {
        OPCPackage pkg = OPCPackage.open(filename);
        XSSFReader r = new XSSFReader(pkg);

        SharedStringsTable sst = r.getSharedStringsTable();
        StylesTable st = r.getStylesTable();
        XMLReader parser = fetchSheetParser(sst, st);

        Iterator<InputStream> sheets = r.getSheetsData();
        while(sheets.hasNext()) {
            System.out.println("Processing new sheet:\n");
            InputStream sheet = sheets.next();
            InputSource sheetSource = new InputSource(sheet);
            parser.parse(sheetSource);
            sheet.close();
            System.out.println("");
        }
    }


    public XMLReader fetchSheetParser(SharedStringsTable sst, StylesTable st) throws SAXException, ParserConfigurationException {
        XMLReader parser = SAXHelper.newXMLReader();
        ContentHandler handler = new SheetHandler(sst, st);
        parser.setContentHandler(handler);
        return parser;
    }


    private static class SheetHandler extends DefaultHandler {

        private SharedStringsTable sst;
        private StylesTable st;
        private String lastCharacters; // characters cache to collect character content between startElement and eneElement
        private String formula; // stores the formula, if any
        private String content; // stores the content, if any
        private boolean nextValueIsSSTString; // indicates that next value is from SharedStringsTable 
        private boolean nextValueIsStyledNumeric; // indicates that next value is a styled numeric value
        private XSSFCellStyle cellStyle; // stores the cell style, if any
        private DataFormatter formatter; // used to format the styled numeric values

        private SheetHandler(SharedStringsTable sst, StylesTable st) {
            this.sst = sst;
            this.st = st;
            this.formatter = new DataFormatter(java.util.Locale.US, true);
        }

        public void startElement(String uri, String localName, String name,
                                 Attributes attributes) throws SAXException {
            // c => start of cell
            if(name.equals("c")) {
                // print the cell reference
                System.out.print(attributes.getValue("r") + " - ");

                // get the cell type
                String cellType = attributes.getValue("t");

                // figure out if the value is an index in the SST
                this.nextValueIsSSTString = false;
                if(cellType != null && cellType.equals("s")) {
                    this.nextValueIsSSTString = true;
                } 

                // figure out if the cell has style
                this.cellStyle = null;
                String styleIdx = attributes.getValue("s");
                if (styleIdx != null) {
                    int styleIndex = Integer.parseInt(styleIdx);
                    this.cellStyle = st.getStyleAt(styleIndex);
                    // print that there is cell style for this cell
                    System.out.print("CellStyle: " + this.cellStyle + " - ");
                }

                // figure out if the value is an styled numeric value or date
                this.nextValueIsStyledNumeric = false;
                if(cellType != null && cellType.equals("n") || cellType == null) {
                    if (this.cellStyle != null) {
                        this.nextValueIsStyledNumeric = true;
                    }
                } 

            }

            // clear characters cache after each element
            this.lastCharacters = "";
        }

        public void endElement(String uri, String localName, String name)
                throws SAXException {

            // f => end of formula in a cell
            if(name.equals("f")) {
                this.formula = lastCharacters;
                // print formula
                System.out.print("Formula: " + this.formula + " - ");
            }

            // v => end of value of a cell
            if(name.equals("v")) {

                this.content = this.lastCharacters;

                // process shared string value
                if(this.nextValueIsSSTString) {
                    int idx = Integer.parseInt(lastCharacters);
                    this.content = sst.getItemAt(idx).getString();
                    nextValueIsSSTString = false;
                }

                // process styled numeric value
                if(this.nextValueIsStyledNumeric) {
                    String formatString = cellStyle.getDataFormatString();
                    int formatIndex = cellStyle.getDataFormat();                    
                    if (formatString == null) {
                        // formatString could not be found, so it must be a builtin format.
                        formatString = BuiltinFormats.getBuiltinFormat(formatIndex);
                    }
                    double value = Double.valueOf(this.content);
                    this.content = formatter.formatRawCellContents(value, formatIndex, formatString);
                    nextValueIsStyledNumeric = false;
                }

            }

            // c => end of a cell
            if(name.equals("c")) {
                // print content
                System.out.println("Content: " + this.content);
                this.content = "";
            }
        }

        public void characters(char[] ch, int start, int length) {
            this.lastCharacters += new String(ch, start, length);
        }
    }

    public static void main(String[] args) throws Exception {
        ExampleEventUserModel example = new ExampleEventUserModel();
        //example.processAllSheets(args[0]);
        example.processAllSheets("ExcelExample.xlsx");
    }
}