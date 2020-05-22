StringBuffer sb = new StringBuffer();
sb.append("foo").append("\n")
  .append("bar").append("\n"); //fake "file reading"

String[] result = sb.toString().split("\n");
for(String s : result){
    System.out.println(s);
}