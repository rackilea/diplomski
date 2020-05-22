List<String> ham=new ArrayList<String>();
List<String> spam=new ArrayList<String>();
if(line.contains("[ham]"))
   ham.add(line.substring(0,line.indexOf("[ham]")));
if(line.contains("[spam]"))
   spam.add(line.substring(0,line.indexOf("[spam]")));