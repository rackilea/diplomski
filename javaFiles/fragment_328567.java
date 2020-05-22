/**
 * Opens a set of items using the given set of paths.
 */
public static void openItems(List<String> urls) {
  try {

    // Create VB script
    String script =
      "Sub Run(ByVal sFile)\n" +
      "Dim shell\n" +
      "Set shell = CreateObject(\"WScript.Shell\")\n" +
      "shell.Run Chr(34) & sFile & Chr(34), 1, False\n" +
      "Set shell = Nothing\n" +
      "End Sub\n";

    File file = new File("openitems.vbs");

    // Format all urls before writing and add a line for each given url
    String urlsString = "";
    for (String url : urls) {
      if (url.startsWith("file:")) {
        url = url.substring(5);
      }
      urlsString += "Run \"" + url + "\"\n";
    }

    // Write UTF-16LE bytes in openitems.vbs
    FileOutputStream fos = new FileOutputStream(file);
    fos.write(script.getBytes("UTF-16LE"));
    fos.write(urlsString.getBytes("UTF-16LE"));
    fos.close();

    // Run vbs file
    Runtime.getRuntime().exec("cmd.exe /C openitems.vbs");

  } catch(Exception e){}
}