StringBuffer output = new StringBuffer();
while (matcher.find()) {
    matcher.appendReplacement(output, SelectRandomFromTemplate(matcher.group(1), count)); 
}
matcher.appendTail(output);
return output.toString();