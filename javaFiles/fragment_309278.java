Matcher matcher = pattern.marcher(origString);
if(matcher.find()){
    System.out.println("DEBUG - HAS A DECIMAL IGNORE");
}
else{
    System.out.println("DEBUG - No Decimal");
}