class Test {
        public static void main(String[] args) {
            // Per your current code.
            for (int i=0; i&lt10; i++) simpleArray(null);
            System.out.println("");

            // What you may be looking for.
            String[] strArr = { "Welcome To CWU BANK!", "Thank you for using CWU ATM!", "Please insert DEBIT card",
            "We value your business!" };
            for (int i=0; i&lt10; i++) simpleArray2(strArr);
        }

        public static void simpleArray(String[] greetings) {
            String[] strArr = { "Welcome To CWU BANK!", "Thank you for using CWU ATM!", "Please insert DEBIT card",
                    "We value your business!" };

            int i = (int) (Math.random() * strArr.length);
            System.out.println(strArr[i]);
        }

        public static void simpleArray2(String[] greetings) {
            int i = (int) (Math.random() * greetings.length);
            System.out.println(greetings[i]);
        }

    }