String str = "hello|145451|new|5565";
String arr[] = str.split("\\|(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

for(String myStr: arr) {
    System.out.println(myStr);
}