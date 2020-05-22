List<String> headerList = Arrays.asList(new String[]{"ID","Name","Gender","Age"});
List<String[]> infoList = Arrays.asList(info);
for(String[] s: infoList){
  int count = 0;
  for(String header : headerList){
    System.out.println(header+": "+s[count]);
    count++;
    }
 }