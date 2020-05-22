public boolean setData(final String str){

        if(str != null && !str.equalsIgnoreCase("")){
                timer.scheduleAtFixedRate(new TimerTask() {
                public void run() {


                            System.out.println("inside run.....");
                                System.out.println("str length:- "+str.length());
                                //do sth after this..

                                }
                     }