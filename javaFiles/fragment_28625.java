@Test
public void createFromPointB() {
    //      {box1=[blue, red, orange]}
    //      {box2=[blue, red, orange]}
    //      {box3=[]}

    //      [{box1=blue, box2=red}, 
    //       {box1=red, box2=orange}, 
    //       {box1=orange, box2=blue}]

    //      0,0 {box1=blue}
    //      0,1 {box1=red}
    //      0,2 {box1=orange}

    //      1,0 {box2=blue}
    //      1,1 {box2=red}
    //      1,2 {box2=orange}

    //      2,x {box3=blue}
    //      2,x {box3=red}
    //      2,X {box3=orange}

    //      0,0     1,1     2,x
    //      0,1     1,1     2,x
    //      0,2     1,0     2,x

    Map<String, List<String>> input = new LinkedHashMap<>();
    input.put("box1", Arrays.asList("blue", "red", "orange"));
    input.put("box2", Arrays.asList("blue", "red", "orange"));
    input.put("box3", Collections.<String>emptyList());

    List<Map<String, String>> output = create(input);
    for(Map<String, String> e : output) {
        System.out.println(e);  
    }
}