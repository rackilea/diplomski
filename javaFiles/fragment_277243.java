Pattern pattern= Pattern.compile("\\d{2}.\\d{2}");
Matcher matcher = pattern.matcher(response);
if(matcher.matches(){ 
    double[] partsD = new double[parts.length];
    for(int i = 1; i < matcher.groupCount(); i++){
        partsD[i] = Double.parseDouble(matcher.group(i));
    }
}