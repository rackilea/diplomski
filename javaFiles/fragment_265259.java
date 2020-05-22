try{
    n2 = Double.parseDouble(inp2);
} catch(NumberFormatException numberFormatException){
    System.out.println("Wrong number format of input: "+inp2+". Exception:" +numberFormatException.getMessage());
    return;
}