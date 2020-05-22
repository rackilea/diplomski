static class Operator extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Operator is working");
            synchronized (strings) {
                System.out.println("Notifying to machine1");
                strings.add(scanner.nextLine());
                strings.notify();
                System.out.println("Notifying to machine2");
                try {
                    strings.wait();
                }catch (Exception ex){}
            }
        }
    }
}

// Machine thread
static class Machine extends Thread {
    @Override
    public void run() {
        while (strings.isEmpty()) {
            System.out.println("strings is empty");
            synchronized (strings) {
                strings.notify();
                try {
                    System.out.println("Machine is waiting 1");
                    strings.wait();
                    System.out.println("Machine is waiting 2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(strings.remove(0));
            }
        }
    }
}