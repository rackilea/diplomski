ArrayList<String> list = new ArrayList();
list.add("fileName124567268xtz");
list.add("1234);
String regex = "fileName.*";
for(int i = 0; i < list.size(); ++i)
 if(list.get(i).matches(regex))
  System.out.println(list.get(i));