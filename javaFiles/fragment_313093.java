Scanner keyBoard = new Scanner(System.in);
System.out.println("Enter a Base Number:");
double baseNumber = keyBoard.nextDouble();

System.out.println("Enter a Raised Number:");
double raisedNumber = keyBoard.nextDouble();

double raisedResult = calcPower(baseNumber, raisedNumber);
dspRaisedNumber(baseNumber, raisedNumber, raisedResult);
keyBoard.close();   // close keyboard scanner