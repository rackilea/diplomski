public static void main(String){
    CD cd = new CD();

    DJ dj1 = new DJ();
    dj1.disk = cd;
    Thread threadDJ1 = new Thread(dj1);

    DJ dj2 = new DJ();
    dj2.disk = cd;
    Thread threadDJ2 = new Thread(dj2);

    threadDJ1.start();
    threadDJ2.start();
}