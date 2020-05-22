try{
    if (input.length() <= 20) {
        // do stuff with your input 
    } else {
        throw new StringTooLongException("'" + input + "' is longer than 20");
    }
} catch(StringTooLongException e){
    System.out.println ("Exceeds string length: " + input);
}