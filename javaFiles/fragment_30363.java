final Object obj = new Object();
...

synchronized(obj) {
    while(/* condition */) {
       obj.wait();
    }
}