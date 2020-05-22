public static void main(String[] args) throws InterruptedException {

        Date today = new Date();
        System.out.println(today);

        Calendar cal = Calendar.getInstance();
        cal.set(2015, 1, 2, 0, 3, 0);

        while (today.before(cal.getTime())) {
            System.out.println("Waiting");
            Thread.sleep(1000);
            today = new Date();
            System.out.println(today);
        }

        System.out.println("Done");

    }