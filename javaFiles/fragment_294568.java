class Example {
    public void myMethod(String let) {
        switch (let) {
        case "A":
            throw new RuntimeException();
        default:
            break;
        }
    }

    public static void main(String[] args) {
        for (String s : new String[]{"A", "B"}) {
            try {
                new Example().myMethod(s);
            } catch (Exception ignore) {
            }
        }
    }
}