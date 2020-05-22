synchronized (addtion) {
    for(int i=0;i<100;i++) {
        ...
        synchronized (this) {
            System.out.println(
                Thread.currentThread().getName() + 
                "---val value lock on addition obj -->" + val++
            );
        }
        System.out.println(
            Thread.currentThread().getName() + 
            "---add value lock on addition obj -->" + addtion.add++
        );
    }
}