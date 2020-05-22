String str = "((X1,Y1),(X2,Y2),(X3,Y3))";

// The below pattern will fail with nested brackets - (X1, (X2, Y2)). 
// But again, that doesn't seem to be the case here.    
Matcher matcher = Pattern.compile("[(][^()]*[)]").matcher(str);

while (matcher.find()) {
    System.out.println(matcher.group());
}