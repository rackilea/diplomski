Date date=new Date();
Timer timer = new Timer();

timer.schedule(new TimerTask(){
     public void run(){
          System.out.println("Im Running..."+new Date());
     }
},date, 24*60*60*1000);//24*60*60*1000 add 24 hours delay between job executions.