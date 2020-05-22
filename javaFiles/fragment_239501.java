String s = "@test, @{@test2, dasdas. @test3?} @test4? @test5!";
Pattern pattern = Pattern.compile("@(\\w+)");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    System.out.println(matcher.group(1)); 
}