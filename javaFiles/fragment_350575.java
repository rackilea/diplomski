String first = request.getParameter("first");
String second = request.getParameter("second");
if(first.contains("second=")){
    second = first.split("second=")[1];
    first = first.split("second=")[0];
}
out.println("[First:"+first+"][Second:"+second+"]");