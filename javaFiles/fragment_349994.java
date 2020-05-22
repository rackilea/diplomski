class Escape {
    Integer mmyInt = 1;

    Escape(){
        new Thread(){
            public void run(){
                System.out.println(Escape.this.mmyInt);
            }
        }.start();
    }
 }