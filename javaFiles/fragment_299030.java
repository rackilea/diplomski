strNum1 = JOptionPane.showInputDialog ("Enter Number String");
boolean isValid = true;
for (int i=0; i<strNum1.length(); i++) {
        char c = strNum1.charAt(i);
        if (c == '-'){
            System.out.println("Negative Digit Found - Exiting");
            isValid = false;
            break;
        }
}
if (isValid) {
    for (int i=0; i<strNum1.length(); i++) {
        char c = strNum1.charAt(i);
        if (c <= '9'){
            System.out.println(c);
        }
    }
}