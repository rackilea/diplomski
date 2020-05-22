for (int i = 0; i < 5; i++) {
    int day = 1+ rnd.nextInt(28); //day from 1 to 28
    int month = 1+rnd.nextInt(12); //day from 1 to 12
    int year = 2000 +rnd.nextInt(13); //year from 2000 to 2012
    String dateString = month+"/"+day+"/"year;
    vE.add(dateString);
 }