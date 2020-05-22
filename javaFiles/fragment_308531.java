final View view=//smth;
...
view.post(new Runnable() {
            @Override
            public void run() {
                view.getHeight(); //height is ready
            }
        });