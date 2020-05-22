public static void main (String args[]){
        String test = "))(2.0+4.0)";
        int i = 0;
        labelLoop :
            for (char now : test.toCharArray()){
                switch (now) {
                case '(':
                    break labelLoop;
                case ')':
                case '/':
                case '*':
                case '+':
                case '-':
                i++;
                }
            }
        System.out.println(i);
    }