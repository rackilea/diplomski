public static class Cookie implements Iedible {
    int bites = 5;

    public void eat() {
        if (bites > 0) System.out.println("*bites cookie* you have only " + --bites + " bites left");
        else System.out.println("no more cookie left :(");
    }
    }