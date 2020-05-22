String nextLine = ""; 
StringBuilder sb = new StringBuilder();
sb.append("{ \n");
while ((nextLine = br.readLine()) != null) {
    sb.append(...);
    sb.append(",");
    sb.append("\n");
}
sb.deleteCharAt(sb.lastIndexOf(","));    //You can check here if string builder has comma to avoid IndexOutofboundException
sb.append("}");