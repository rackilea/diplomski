String secret = "a";
Boolean isFounded = false;
while (true) {
    System.out.println(" Enter guess:");
    String guess = keyboard.nextLine();
    for (int i = 0; i < guess.length(); i++) {
         if (guess.equals(secret)) {
              System.out.println("YOU got it!"); 
              isFounded = true;
         }
         if(isFounded) break;
     }
     if(isFounded) break;
}