int number1Int = 0;
    double number1Double = 0.0;
    String num1 = JOptionPane.showInputDialog("Enter a number");

    //EDIT: added boolean flag per comments
    boolean isInt = false;
    try{
        number1Int = Integer.parseInt(num1);
        isInt = true;
        JOptionPane.showMessageDialog(null, "The number is " + number1Int);
    }catch(NumberFormatException e){
        System.out.println("User did not enter an integer.");
    }
    if(!isInt){
        try{
            number1Double = Double.parseDouble(num1);
            JOptionPane.showMessageDialog(null, "The number is " + number1Double);
        }catch(NumberFormatException e){
            System.out.println("User did not enter a double.");
        }
    }