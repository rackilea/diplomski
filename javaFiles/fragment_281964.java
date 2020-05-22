Random random = new Random();
int index = random.nextInt(25);

String [] alphabets = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L","M", "N","O","P","Q", "R", "S", "T", "U", "V","W", "X","Y","Z"};

String mRandomAlphabet = alphabets[index];
Log.i("Random Alphabet", mRandomAlphabet);