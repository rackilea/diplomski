@Override
public void run() {
    while(!exit) {
        System.out.println(t.currentThread().getName()+": "+num);
        num++;  
        try {
            t.sleep(200);   
        } catch(InterruptedException e) {}

        if (rp.num == 1) {
          exit = true;
        }
    }
}