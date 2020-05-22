@Test
public void createFromPointF() {
    //      {box1=red, box2=blue, box3=orange}
    //      {box1=blue, box2=orange, box3=purple}
    //      {box1=red, box3=pink}
    //      {box3=red, box1=orange}
    //      {box3=blue}

    //      0,0    {box1=red}
    //      0,1    {box1=blue}
    //      0,2    {box1=orange}
    //      0,x    {box1=purple}
    //      0,x    {box1=pink}
    //
    //      1,0    {box2=red}
    //      1,1    {box2=blue}
    //      1,2    {box2=orange}
    //      1,x    {box2=purple}
    //      1,x    {box2=pink}
    //
    //      2,0    {box3=red}
    //      2,1    {box3=blue}
    //      2,2    {box3=orange}
    //      2,3    {box3=purple}
    //      2,4    {box3=pink}

    //      0,0     1,1     2,2
    //      0,1     1,2     2,3
    //      0,x     1,x     2,0
    //      0,x     1,0     2,1

    Map<String, List<String>> input = new LinkedHashMap<>();
    input.put("box1", Arrays.asList("red", "blue", "orange"));
    input.put("box2", Arrays.asList("red", "blue", "orange"));
    input.put("box3", Arrays.asList("red", "blue", "orange", "purple", "pink"));

    List<Map<String, String>> output = create(input);
    Assert.assertEquals(
            "{box1=red, box2=blue, box3=orange}\r\n" + 
            "{box1=blue, box2=orange, box3=purple}\r\n" + 
            "{box1=orange, box3=pink}\r\n" + 
            "{box3=red}\r\n" + 
            "{box2=red, box3=blue}\r\n", toString(output));
}

private String toString(List<Map<String, String>> output) {
    StringWriter sw = new StringWriter();
    for(Map<String, String> e : output) {
        sw.write(e.toString());
        sw.write("\r\n");
    }
    return sw.toString();
}