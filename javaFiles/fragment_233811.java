Parameters params = getParameters();
List<String> list = params.getRaw();
System.out.println(list.size());
for(String each : list){
    System.out.println(each);
}