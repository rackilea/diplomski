class Util {
  static native void info (Object obj) /*-{
    if ($wnd.console && $wnd.console.log) $wnd.console.log (obj)
  }-*/;

  /** Fires a "click" event on an HTML element. */
  public static native void click (final JavaScriptObject element) /*-{
    if (element.click) element.click();
  }-*/;

  /** Read a file from the local filesystem. The file should have been choosen via an `input type=file`.
   * See also: http://www.html5rocks.com/ru/tutorials/file/dndfiles/; http://www.w3.org/TR/FileAPI/ */
  public static native void readFile (JavaScriptObject inputFile, V1<String> andThen) /*-{
    var files = inputFile.files
    if ($wnd.console) $wnd.console.log ('readFile; input: ', inputFile, files)
    if (!files || !files.length) return
    var reader = new FileReader()
    reader.onload = function (progressEvent) {
      //$wnd.console.log ('read event: ', progressEvent, 'read: ', reader.result)
      andThen.@client.Closure.V1::call(Ljava/lang/Object;)(reader.result)
    }
    reader.readAsDataURL (files[0])
  }-*/;
}

// Remove old form.
final Element oldForm = Document.get().getElementById ("uploadForm");
if (oldForm != null) oldForm.getParentNode().removeChild (oldForm);

// A hidden form used to upload the files.
final FormPanel form = new FormPanel();
form.getElement().setId ("uploadForm");
final Style formStyle = form.getElement().getStyle();
formStyle.setDisplay (Display.INLINE_BLOCK); formStyle.setOverflow (Overflow.HIDDEN); formStyle.setWidth (0, Unit.PX); formStyle.setHeight (0, Unit.PX);
form.setAction ("http://.../");
form.setEncoding (FormPanel.ENCODING_MULTIPART); form.setMethod (FormPanel.METHOD_POST);
final FileUpload upload = new FileUpload(); upload.setName ("image");
form.add (upload);
RootPanel.get().add (form);

upload.addChangeHandler (new ChangeHandler() {public void onChange (final ChangeEvent event) {
  Util.info ("Loading: " + upload.getFilename());
  Util.readFile (upload.getElement(), new V1<String>() {public void call (final String dataURL) {
    Util.info ("Loaded: " + upload.getFilename() + " (url is " + dataURL.length() + " bytes)");
  }});
}});

// Trigger the upload dialogue. See also: http://aspalliance.com/articleViewer.aspx?aId=1441&pId=-1
Util.click (upload.getElement());