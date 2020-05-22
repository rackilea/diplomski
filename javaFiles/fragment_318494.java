public static void main(String[] args) {
    Triangle triangle = null;
    try {
         triangle = new Triangle(2, 3, 4);
    } catch (InvalidValueException e) {
        e.printStackTrace();
    }
}