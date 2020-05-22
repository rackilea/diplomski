class GapFill {

    private static String numbers; //E.g. 6_5_4=15
    private static String[] blank; //Array of operators to go in the blanks

    //Where:
    //p = plus
    //m = minus
    //d = divide
    //t = times
    private static String[] operators = {"p", "m", "d,", "t"};

    public static void main(String[] args) {
        numbers = args[0];
        blank = new String[numbers.split("_").length - 1];
        if(dfs(0)) { //If a solution was found
            int count = 0;
            while(numbers.indexOf("_")!=-1) {
                int index = numbers.indexOf("_");
                numbers = numbers.substring(0,index)+blank[count]+numbers.substring(index+1);
                count++;
            }
            System.out.println(numbers);
        }
    }

    private static boolean dfs(int i) {
        if(i == blank.length) {  //base case: filled in all the blanks
            return solveEquation();
        }
        for(String op : operators) {
            blank[i] = op;
            if(dfs(i + 1)) {
                return true;
            }
        }
        blank[i] = "_"; //restore to previous state
        return false;
    }

    private static boolean solveEquation() {
        String[] eachNumber = numbers.substring(0, numbers.indexOf("=")).split("_");
        String finalResult = numbers.substring(numbers.indexOf("=")+1, numbers.length());
        double currentResult = Double.parseDouble(eachNumber[0]);
        for(int i=1;i<eachNumber.length;i++) {
            String op = blank[i-1];
            if(op==operators[0]) {
                currentResult = currentResult + Integer.parseInt(eachNumber[i]);
            } else if(op==operators[1]) {
                currentResult = currentResult - Integer.parseInt(eachNumber[i]);
            } else if(op==operators[2]) {
                currentResult = currentResult / Integer.parseInt(eachNumber[i]);
            } else if(op==operators[3]) {
                currentResult = currentResult * Integer.parseInt(eachNumber[i]);
            }
        }
        return (currentResult==Integer.parseInt(finalResult));
    }

}