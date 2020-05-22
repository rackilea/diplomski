String outtext = output.getText();
String newtext = outtext;
int totalreplaced = 0;

//check if there is anything to replace
while( !newtext.replaceFirst(repfrom, repto).equals(newtext) ) {
    newtext = newtext.replaceFirst(repfrom, repto);
    totalreplaced++;
}

message("Total replaced: " + totalreplaced + " from " + repfrom + " to " + repto);