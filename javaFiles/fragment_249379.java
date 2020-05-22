String label1 = "foo";
String label2 = "bar";
String label3 = "x";

private void printAll() {
    for (Field f : this.getClass().getDeclaredFields()) {
        if (f.getName().matches("label[1-9]")) {
            try {
                String value = (String) f.get(this);
                if (value.equals("x")) {
                    System.out.println(f.getName() + " is x");
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}