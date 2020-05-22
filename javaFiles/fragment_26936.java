public class MyClass {

    private enum Answer {

        ACCEPT ("Yes"),
        DENY ("No"),
        TENTATIVE("Maybe"),
        POSTPONE("Later");

        private final String answer;

        private Answer(String answer) {
        this.answer = answer;
        }

        public String toString() {
            return answer;
        }
    }
}