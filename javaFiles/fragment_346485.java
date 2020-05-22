synchronized(x){
        while(x.count < 4) {
          x.wait();
          //...
        }
}