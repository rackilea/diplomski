List<String> result = new ArrayList();
for(String i: yourStringArray){
    if(i.matches(sb.toString()))
        {
             result.add(i);
         }
}