String target = sdbTarget.getText();
if (target != null && !target.trim().isEmpty()) {
    File targetFile = new File(target)
    String function = event.getActionCommand();                                 //Reads the ActionCommand into a string for use in performing desired function
    if (function.equals("Read")) {                                              //Read function
        Desktop desktop = Desktop.getDesktop();                                 //For the GUI version, supposed to open "targetFile" upon readButtonClick
        desktop.open(targetFile);                                               
        //...