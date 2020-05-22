public String add(String a, String b) {
    return a + b;
}

public int add(int a, int b) {
    return a + b;
}

add("a", "b"); // calls first version of add
add(1, 2); // calls second version of add