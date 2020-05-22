/** Returns a stringy version of this deck. */
    public String toString() {
         String output="Current Deck:\n";
         for (int i=0; i <cards.length ; i++){
          output+= cardAt(i).toString();
         }
       return output;
    }