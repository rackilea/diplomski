public static void main(String[] args) throws ScriptException {

    int[] letterArray = new int[26];

    Scanner keyboard = new Scanner(System.in);
    boolean inUse = true;
    int num = 0;

    // initial assigning of characters
    for (int j = 0; j < letterArray.length; j++) {
        letterArray[j] = j + 1;

    }
    System.out.println("Default value of characters: ");
    printArray(letterArray);
    while (inUse) {

        System.out
                .println("enter 1 to change a value of a specific character..");
        System.out.println("enter 2 to compute an expression...");
        System.out.println("enter 3 or any other number to quit");

        System.out.print("Input: ");
        num = keyboard.nextInt();

        if (num == 1) {
            changeValue(letterArray, keyboard);
        } else if (num == 2) {
            System.out.println(computeExpression(keyboard, letterArray));
        } else {
            System.out.println("bye.");
            return;
        }

    }

}

public static void changeValue(int[] array, Scanner keyboard) {
    System.out
            .println("Enter the letter you will like to change: i.e A or B or C...");
    String character = keyboard.next().toUpperCase();
    // changing each input to upper-case to stay consistent
    // with the base value of 65
    int charnum = (int) character.charAt(0);
    if (Character.isLetter(character.charAt(0))) {
        System.out
                .println("Enter the value you are assigning to this character: ");

        array[charnum - 65] = keyboard.nextInt();
    } else {
        System.out
                .println("You entered an invalid character, sorry gotta start the process again");
    }

    System.out.println("Character Values: ");
    printArray(array);

}

// computing expression with ScriptEngineManager
// stole this from
// https://stackoverflow.com/questions/3422673/evaluating-a-math-expression-given-in-string-form
// this is where you will want to implement your stack-based logic to
// analyze the expression
// and compute the result after replacing each character with it's assigned
// value
public static int computeExpression(Scanner keyboard, int[] array)
        throws ScriptException {
    System.out.println("enter expression you will like to compute: ");

    String expr = keyboard.next();

    expr = replaceValues(array, expr);
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");
    // int result = Integer.parseInt((String) (engine.eval(expr)));
    return (Integer.parseInt(engine.eval(expr).toString()));
}

// replacing each character with assigned value
public static String replaceValues(int[] array, String expr) {
    expr = expr.toUpperCase();
    int position = 0;
    for (char c : expr.toCharArray()) {
        if (Character.isLetter(c)) {

            position = (int) c - 65;
            expr = expr.replace(Character.toString(c),
                    Integer.toString(array[position]));
        }
    }
    System.out.println(expr);
    return expr;
}

// printing out each character value
public static void printArray(int[] array) {
    int count = 0;
    for (int eachCh : array) {
        System.out.print((char) (65 + count) + "->" + eachCh + "|||");
        count++;
    }
    System.out.println();
}