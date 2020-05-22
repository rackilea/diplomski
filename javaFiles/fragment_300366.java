String inputtext =  "some Input text";

//Initialize your patterns:
String p1 = "pattern one";
String p2 = "pattern two";
String p3 = "pattern three";

//Then, create matchers for each of the patterns on the input text.
Matcher m1=Pattern.compile(p1).matcher(inputtext);
Matcher m2=Pattern.compile(p2).matcher(inputtext);
Matcher p3=Pattern.compile(p3).matcher(inputtext);

//Don't repeat yourself - initialize your author and title out here, then only
//write the print statements once.

String author=null;
String title = null;

if (m1.find()) {                //if inputtext matches p1
    title = m1.group(2).trim();
    author = m1.group(4).trim();
} else if (m2.find()) {           //else if inputtext matches p2
    title = m2.group(1).trim();
    author = m2.group(3).trim();
} else if (m3.find()) {            //else if inputtext matches p3
    author = m3.group(2).trim();
    title = m3.group(4).trim();
}

if (author ==null || title == null) {   //If no matches set the author and title strings...
    System.out.println("Not match");    //There's no match
} else {                                //Otherwise...
                                       // We have a match!
    System.out.println("اسم المؤلف : " + author);
    System.out.println("عنوان الكتاب : " + title);
}