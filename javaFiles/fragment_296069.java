public synchronized void writeList() {
      while (true) {
            if (flag) {
                count++;
                list.add(count);
                System.out.println("inise if block...." + Thread.currentThread().getName());
                System.out.println(list);
                flag = false;
                try {
                    notify(); //notify the read thread that write is complete
                    wait();   // go into the waiting state so that no further write is done until the current element is removed by the read thread.
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    wait(); //wait in else, otherwise while will run endlessly
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
           }
      }
 }

 public synchronized void readList() {
        while (true) {
            System.out.println("in read");
            if (!flag) {
                Integer i = list.remove(0);
                System.out.println(i + "..removed at index by" + Thread.currentThread().getName());
                flag = true;
                try {
                    notify(); //notify write thread that read is complete
                    wait();   //go into wait until new element is inserted
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    wait(); //wait in else otherwise while runs endlessly
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }