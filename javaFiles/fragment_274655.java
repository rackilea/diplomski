StringBuilder string = new StringBuilder();
File[] roots = File.listRoots();   
for(File root: roots)  
{  
      string.append(root).append("\n");  
}
System.out.println(string);