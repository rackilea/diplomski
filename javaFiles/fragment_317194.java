Single.just(getInstance(context).initData())
        .subscribeOn(Schedulers.io())
        .subscribe(result -> {
            if(result)
                System.out.println("Init successful");
            else
                System.out.println("Init unsuccessful");
        }, error -> {
            System.out.println("Error occurred: " + error);
        });