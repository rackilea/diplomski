try {
        SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
                System.out.println("1");
                if (true) {
                    throw new RuntimeException("runtime exception");
                }
                System.out.println("2");
            }
        });
    } catch (InterruptedException e) {
        e.printStackTrace(System.out);
    } catch (InvocationTargetException e) {
        e.printStackTrace(System.out);
    }