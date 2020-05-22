private Random rand = new java.util.Random();

 public void generateRandom(char how){
    switch(how){
        case 'a':
            for(int i = 0; i < passwordArray.length; i++){
                passwordArray[i] = alphabet[rand.nextInt(alphabet.length)];
            }
            .
            .
            .