public static void main(String... args) {
    static class EnglishGoodbye { //static local classes not allowed
        public static void sayGoodbye() {
            System.out.println("Bye bye");
        }
    }
    EnglishGoodbye.sayGoodbye();
}