class MyClass {

private Color color;
private String someOtherProperty;
public static final Comparator<MyClass> COLOR_COMPARATOR = new MyComparator();

//getter and setter

static class MyComparator implements Comparator<MyClass>{

            @Override
            public int compare(MyClass o1, MyClass o2) {
                // here you do your business logic, when you say where a color is greater than other
            }    
}

}