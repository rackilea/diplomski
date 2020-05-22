try {

        System.setOut(new PrintStream(new FileOutputStream("C:\\TMP\\logs.log")));
                    long startTime = Calendar.getInstance().getTimeInMillis();
        for (int a=0;a<15000;a++) {
            System.out.println("Printing line : #"+a);
        }

        long elapsedTime = (Calendar.getInstance().getTimeInMillis() - startTime);
        System.out.println("System.out took: " + elapsedTime + "ms");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }