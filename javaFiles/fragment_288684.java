public static void main(String[] args) {

        Date today = new Date();
        System.out.println(today);

        Calendar cal = Calendar.getInstance();
        cal.set(2015, 1, 2, 0, 3, 0);

        while (today.before(cal.getTime())) {
            System.out.println("Waiting");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            today = new Date();
            System.out.println(today);
        }

        System.out.println("Done");

    }