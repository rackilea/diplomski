rx.Observable.from(new String[]{"Test1", "Test2", "Test3", "Test4"})
                .zipWith(rx.Observable.interval(2000, 1000, TimeUnit.MILLISECONDS), (a, b) -> a)
                .concatWith(Observable.timer(2, TimeUnit.SECONDS).map(notUsed -> "The end"))
                .subscribe(name -> {
                            System.out.println(name);
                        }, e -> {
                            System.out.println("ERROR" + e);
                        }
                );


        try {
            // Sleep so the program doesn't exit immediately
            Thread.sleep(10000);
        } catch (Exception e) {

        }