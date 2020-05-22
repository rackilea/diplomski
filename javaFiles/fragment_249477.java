class CompositeCounter implements Runnable{
 final int start,end;
 public CompositeCounter(int s, int e){
     start = s;
     end = e;
 }
 public void run(){
   int count=0;
   for(int i=start;i<=end;i++)
     {
       for(int j=2;j<i;j++){
          if(i%j==0)
            count=count+1;
    }
    if(count>0)
        System.out.println(i);
    count=0;
  }
}
Thread first = new Thread(new CompositeCounter(3,50);
Thread second = new Thread(new CompositeCounter(51,100);
first.start();
second.start();