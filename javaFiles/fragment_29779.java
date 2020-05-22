for (int i = 0; i < 10; i++) {
    do{
       mx = randomGenerator.nextInt(10);
       my = randomGenerator.nextInt(10);
    }while(!grid.place(mx,my));

}