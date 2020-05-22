String s = "Some string preceding this {\"Key1\": \"Val1\", \"Key2\": {\"embedKey1\": \"embedVal1\", \"embedKey2\": \"embedVal2\"}, \"Key3\" : \"Val3\", \"Key3\": \"Val4\"}, some value proceeding it";
Pattern p = Pattern.compile("(?s)\\{(.*)}");
Matcher m = p.matcher(s);
while(m.find()){
    System.out.println(m.group(1));
}