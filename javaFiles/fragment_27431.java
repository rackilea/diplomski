Map<String, String> m = new HashMap<String, String>() {{
    put("lastModifiedDate", "2010-11-26");
}};

SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
SimpleDateFormat formatterParse = new SimpleDateFormat("yyyy-MM-dd");
String s = formatter.format(formatterParse.parse(m.get("lastModifiedDate")));

System.out.println(s);