for (Scanner s = new Scanner(Mphrase); s.hasNext();) {
    String letter = s.next();
    for(int index = 0; index < Morse.length; index++) {
       if(letter.equals(Morse[index])) { 
          System.out.println(Aplphabet[index]);
          break;
       }
    }
}