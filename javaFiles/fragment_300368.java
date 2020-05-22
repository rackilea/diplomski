String inputtext =  "some Input text";

//Initialize your patterns:
PatterWrapper[] patterns = {
    new PatternWrapper("pattern one", 4, 2)
    , new PatternWrapper("pattern two", 3, 1)
    , new PatternWrapper("pattern three", 4, 2)
}

//Don't repeat yourself - initialize your author and title out here, then only
//write the print statements once.

String author=null;
String title = null;

for (PatternWrapper pw : patterns){
    matcher = pw.pattern.matcher(inputtext);
    if (matcher.find()) {
        title = matcher.group(pw.titleGroup).trim();
        author = matcher.group(pw.authorGroup).trim();
        break;
    }
}

if (author ==null || title == null) {   //If no matches set the author and title strings...
    System.out.println("Not match");    //There's no match
} else {                                //Otherwise...
                                       // We have a match!
    System.out.println("اسم المؤلف : " + author);
    System.out.println("عنوان الكتاب : " + title);
}