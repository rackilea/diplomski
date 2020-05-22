BG = //The CSS String, you need to wrap with a Try/Catch to capture a MalformedURLException, but I'm too lazy to do that here...
    "-fx-background-position : 50% 50%;\n" +
    "-fx-background-repeat : no-repeat;\n" +
    "-fx-background-size : contain;\n" +
    "-fx-background-image : url(\"" + GS.bgImage.toURI().toURL + "\");\n";

BG += "-fx-border-width : " + GS.borderWidth + ";\n" //For adding the Border
    + "-fx-border-color : " + GS.borderColor.toString();