while(finalanswer == 0){
    System.out.println("If finished, type 'done'.");
    System.out.println("To change your operation, type 'change'. Otherwise, enter your next number.");
    String input = calc.next();
    if(input.equals("done")){
        finalanswer = 1; break;
    }else if(input.equals("change")){
        System.out.println("'addition', 'subtraction', 'division', or 'multiplication'?");
        userOperation = calc.next();
    }else{
    modanswer = Integer.parseInt(input);
...