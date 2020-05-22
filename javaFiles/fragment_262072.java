public static void main(String... args) {
    class EnglishGoodbye {
        public static void sayGoodbye() { // this cannot be done
            System.out.println("Bye bye");
        }
    }
    EnglishGoodbye.sayGoodbye();
}