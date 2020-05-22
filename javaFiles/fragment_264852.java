....
int input; 
String inputStr = entrada.nextLine();

while(inputStr.replaceAll("\\D","").length() != inputStr.length() || Integer.parseInt(inputStr) <= 0){
    System.out.println("Error, use un numero que sea mayor que cero:");
    inputStr= entrada.nextLine();
}
input = Integer.parseInt(inputStr);
....