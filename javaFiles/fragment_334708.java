String input = br.readLine();
if(input.matches("\\d+"))  // Only ints so don't actually need to consider decimals
    //is a number... do relevant code
    temperature = Integer.parseInt(input);
else
    //not a number
    System.out.println("Not a number that was input");