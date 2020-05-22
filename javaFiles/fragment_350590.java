@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ObjectA {
    private int id;
    private List<String> names;
}

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ObjectB {
    private String name;
    private int age;
}

//And the result Object you want to get
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class ObjectC {
    private int id;
    private String name;
    private int age;
}