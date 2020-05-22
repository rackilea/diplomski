String line = "@client.test.annotations.TestInfo(id=[C10137])@org.testng.annotations.Test(alwaysRun=false, expectedExceptions=[].."; 
String pattern = "\\bid\\b=\\[(.+?)\\]";
Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(line);

if (m.find()) {
    System.out.println(m.group(1));
}