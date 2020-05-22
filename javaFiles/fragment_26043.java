public static void main(String[] args){
    Thread[] grp1 = new Thread[2];
    Thread[] grp2 = new Thread[2];
    CountDownLatch c1 = new CountDownLatch(1);
    CountDownLatch c2 = new CountDownLatch(1);

    grp1[0]=new Thread(new Player1(c1, "grp1:player1"));
    grp1[1]=new Thread(new Player2(c2, "grp1:player2"));


    grp2[0]=new Thread(new Player1(c2, "grp2:player1"));
    grp2[1]=new Thread(new Player2(c2, "grp2:player2"));

    grp1[0].start();
    grp2[0].start();
    grp1[1].start();
    grp2[1].start();
}