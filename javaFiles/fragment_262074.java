public static void main(String... args) {
    final String message = "Bye bye";
    class EnglishGoodbye {
        public static void sayGoodbye() { // this cannot be done
            System.out.println(message);
        }
    }
    EnglishGoodbye.sayGoodbye();
}