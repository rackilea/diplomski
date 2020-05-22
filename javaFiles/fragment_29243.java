public synchronized Integer pop(){
            while(index==0) {
                try{
                    this.wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            index--;
            System.out.println("Consuming a new object."+buffer[index]);
            Integer res=buffer[index];// 
            this.notify();//MISSED
            return res;
        }