public static void doCalculate(String equation) {
            // make it explicit:
            System.out.println("Got:" + equation);
            Pattern pattern = Pattern.compile("([0-9]+|[a-z\\)])(?=[0-9]+|[a-z\\(])");
            Matcher m = pattern.matcher(equation);
            System.out.println("Made it: "+ (equation = m.replaceAll("$1*")));
            //our stacks for storage/temp variables
            Stack<Operator> operatorStack;
            Stack<Double> operandStack;
            double valOne, valTwo, newVal;
            Operator temp;