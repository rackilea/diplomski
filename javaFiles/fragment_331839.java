String s = " {\"responseData\":{\"translatedText\":\"Ciao mondo\"},\"responseDetails\":\"\",\"responseStatus\":200,\"matches\":[{\"id\":\"424913311\",\"segment\":\"Hello World\",\"translation\":\"Ciao mondo\",\"quality\":\"74\",\"reference\":\"\",\"usage-count\":50,\"subject\":\"All\",\"created-by\":\"\",\"last-updated-by\":null,\"create-date\":\"2011-12-29 19:14:22\",\"last-update-date\":\"2011-12-29 19:14:22\",\"match\":1},{\"id\":\"0\",\"segment\":\"Hello World\",\"translation\":\"Ciao a tutti\",\"quality\":\"70\",\"reference\":\"Machine Translation provided by Google, Microsoft, Worldlingo or the MyMemory customized engine.\",\"usage-count\":1,\"subject\":\"All\",\"created-by\":\"MT!\",\"last-updated-by\":null,\"create-date\":\"2012-05-14\",\"last-update-date\":\"2012-05-14\",\"match\":0.85}]}";
System.out.println(s);
Pattern p = Pattern.compile("\"translatedText\":\"([^\"]*)\"");
Matcher m = p.matcher(s);
if (!m.find()) return;
System.out.println(m.group(1));