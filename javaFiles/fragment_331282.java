StringBuilder sb = new StringBuilder();
sb.append("line 1");
sb.append("\\n");
sb.append("line 2");

String[] lines = sb.toString().split("\\n");
for(String s: lines){
    System.out.println("Content = " + s);
    System.out.println("Length = " + s.length());
}