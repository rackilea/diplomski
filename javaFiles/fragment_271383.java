String[] names = request.getParameterValues("Name");
StringBuilder name = new StringBuilder("(");
for(int index = 0; index <names.length; index++){
    name.append("'");
    name.append(names[index].replace("\\","").replace("/",""));
    name.append("'");
    name.append(index != names.length -1? "," : ")");
}
String output = name.toString();