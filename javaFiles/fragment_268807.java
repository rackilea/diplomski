for(int i=0;i<2;i++)
    {
        list.add(new SingleProcess.MyThread(erastotenes,numbers.subList((numbers.size()/2)*i,(numbers.size()/2)*i+numbers.size()/2)));
        list.get(list.size()-1).start();
    }
    for (Thread t : list) {
        t.join();
    }