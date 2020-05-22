public static void main(String[] args) {
        Logger.getLogger().info("This is info message");

        System.out.println("I am free");


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

            //stop the log
        Logger.getLogger().interrupt();

    }