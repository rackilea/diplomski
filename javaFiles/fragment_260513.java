private void printStatus() {
    synchronized (System.out) {
        System.out.println("\t\t\t" + Thread.currentThread().getName());
        System.out.println("\t\t\tCookies: " + contents);
    }
}

public void putCookie(int amount) {  
    printStatus();
    contents += amount;
    synchronized (System.out) {
        System.out.println(amount + " cookies were Put");
    }
}

...