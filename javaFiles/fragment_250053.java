private static char getOperatore(String fromClientString){  
    char operatore;
    switch(fromClientString){
        case "+":
            operatore = fromClientString.charAt(0);
            break;
        case "-":
            operatore = fromClientString.charAt(0);
            break;
        case "*":
            operatore = fromClientString.charAt(0);
            break;
        case "/":
            operatore = fromClientString.charAt(0);
            break;
        default:
            break;
    }

    return operatore;
 }