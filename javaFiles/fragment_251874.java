Random random =new Random();
    int r,c;
    //for horizontal
     r=random.nextInt(maxSize-wordLength);
     c=random.nextInt(maxSize);
    //for vertical
     r=random.nextInt(maxSize);
     c=random.nextInt(maxSize-wordLength);