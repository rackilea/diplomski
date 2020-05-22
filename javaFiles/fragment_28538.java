List<String> list = new ArrayList<String>(3);
for(Text v : values){
    list.add(v.toString());     
}
Collections.sort(list);

StringBuilder builder = new StringBuilder();
for(String s : list){
    builder.append(s.substring(2)+"\t");    
} 

context.write(key, new Text(builder.toString().trim()));