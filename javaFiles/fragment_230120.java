public void myMultipurposeMethod(List<GameObject> ls) {
    synchronized (ls) {
        if (Thread.currentThread().equals(t1)) {
            while (true) {                    
                for (Iterator<GameObject> i = ls.iterator(); i.hasNext(); ) {
                    i.next().render(Thread.currentThread());
                    ls.notify();
                }
                try {
                    ls.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if (Thread.currentThread().equals(t2)) {
            while (true) {
                for (Iterator<GameObject> i = ls.iterator(); i.hasNext(); ) {
                    GameObject o = i.next();
                    o.update(Thread.currentThread());
                    if (o.shouldBeRemoved()) {
                        i.remove();
                        System.out.println("game object with id=" + o.id + " marked as garbage and was removed");
                    }
                }
                ls.notify();

                try {
                    ls.wait();
                } catch (InterruptedException e) {
                    e.printStackTract();
                }
            }
        }
    }
}