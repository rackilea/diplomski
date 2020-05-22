public void delay(String s, long delay) {
    for ( int i= 0; i < s.length(); i++) { 
          // for loop delays individual String characters

        System.out.print(s.charAt(i));
        Thread.sleep(delay); //time is in milliseconds
    }
    System.out.println(""); // this is the space in between lines
}