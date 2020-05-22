public void play(){
    ArrayList<String> edited= new ArrayList<>();
    Scanner input= new Scanner(System.in);


    for(String x: story1){
  //  ^Takes the ArrayList of the story and reformats into a new string. 
  //  This takes the ArrayList story1, and removes the commas and brackets in between lines. 
        StringBuffer buffer1= new StringBuffer(x);

        for(int i=0; i<buffer1.length();i++){
            if(buffer1.charAt(i)=='['){
                int firstChar=i;
                while(buffer1.charAt(i)!=']')
    //^Searches for characters in the string that match brackets.  The loop is supposed to stop at the last bracket, replace the word, and then continue. 
                    i++;
                    int lastIndex=i;

                    String word=buffer1.substring(firstChar+1, lastIndex);

                    char firstLetter= word.charAt(0);

    /**String word is not used for replacement, but simply to read the word inside the brackets[].  
     * If word in brackets begins with a vowel, such as adjective, the prompt is...
     * Enter an adjective.  If the word begins with a consonant, such as verb, the prompt is...
     * Enter a verb.
     * The word entered by the user is put through the buffer, and it replaces the word inside the brackets[]. 
     */     
                    if(firstLetter=='a'|| firstLetter== 'e'|| firstLetter=='i'|| firstLetter=='o'||firstLetter=='u'){
                        System.out.println("Enter an "+word+": ");

                    }
                    else{
                        System.out.println("Enter a "+word+": ");

                    }
                    String newWord= input.nextLine();
                buffer1.replace(firstChar, lastIndex+1, newWord);

            }

        }
            //buffer1 is formatted into a toString(), and put into an ArrayList edited. 
        edited.add(buffer1.toString());

    }
    //ArrayList edited it put into a String format, called x, and then printed.  
    for(String x:edited){
        System.out.println(x);
    }