class Example {

    public static void main(String[] args){

        List<Parent> parentList = new ArrayList<>();

        // init parents with children

        parentList.forEach(parent -> 
             parent.getChildren().removeIf(Example::childOlderThan10)
        );

    }

    static boolean childOlderThan10(Child child) {
        return child != null && child.getAge() > 10;
    }
}