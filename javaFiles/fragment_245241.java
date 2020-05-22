if (flag) {
        wait();
    }
    System.out.println(msg);
    flag = true;
    notify();