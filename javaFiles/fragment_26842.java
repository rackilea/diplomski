StringBuilder exprBuilder = new StringBuilder("//");

for (String element : searchElementsXml[j].split("/")) {
    exprBuilder.append("*[local-name()='" + element + "']/");
}

exprBuilder.append("childnode");

expression = exprBuilder.toString();