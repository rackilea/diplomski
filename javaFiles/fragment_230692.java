int number1 = (int)(Math.random()* 10) + 1;
int number2 = (int)(Math.random()* 10) + 1;
int operator = (int)(Math.random()* 3) + 1;
String operation = null; // move outside of switch block
int correctResult; // move outside of switch block

    switch (operator){
        case 1: {
            operation = "+";
            correctResult = number1 + number2;
            break;
        }
        case 2: {
            operation = "-";
            correctResult = number1 - number2;
            break;
        }
        case 3: {
            operation = "*";
            correctResult = number1 * number2;
            break;
        }
    }
System.out.print(number1+operation+number2+": ");
String studentAnswer = scanner.next();