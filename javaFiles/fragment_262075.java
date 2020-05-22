public static void main(String... args) {
    final String message = "Bye bye";
    class EnglishGoodbye {
        public void sayGoodbye() {
            System.out.println(message);
        }
    }
    new EnglishGoodbye().sayGoodbye();
}