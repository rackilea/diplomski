ArrayList<SomeClass> myArrayList = new ArrayList<SomeClass>();
myArrayList..addAll(new ArrayList<Integer>() {{
        add(1);
        add(2);
        add(3);
    }});