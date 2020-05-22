Page myPage = ... // the Page object

Date date = new Date();
SimpleDateFormat df = new SimpleDateFormat("_yyyy-MM-dd_HH-mm");
String newName = myPage.getName() + df.format(date);

pageManager.copy(myPage, newName, null, true, false);