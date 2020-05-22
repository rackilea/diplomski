Scanner input = new Scanner(System.in);

char letter = 0; 
String[] words = {/*"yes",*/ "no"}; 
String word_random = words[(int) (Math.random() * words.length)]; 
boolean[] word_found = new boolean[word_random.length()];
int attempts = 5;

while(attempts > 0){
  System.out.println("You have " + attempts + " attempts.");
  for(int i=0; i<word_random.length(); i++) {
    if ( word_found[i] ) {
      System.out.print(word_random.charAt(i));
    }
    else {
      System.out.print('-');
    }
  }

  System.out.println("");
  System.out.print("Enter your letter : ");
  letter = input.next().charAt(0);

  for(int i=0; i<word_random.length();i++){
    if(word_random.charAt(i) == letter){
      System.out.println("The letter is good. ");
      word_found[i] = true;
    } 

  }

  boolean done = true;
  for(boolean b : word_found)
       done = done && b;

   if(done) break;
   else attempts--;

   }