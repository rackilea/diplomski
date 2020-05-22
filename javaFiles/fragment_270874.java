while (playing) {
     // Code to do another drawing

     if (credits == 0) {
         System.out.println("\nYou lose !");
         playing = false;
     } else if (credits == 10) {
         System.out.println("\nYou win !");
         playing = false;
     }
}