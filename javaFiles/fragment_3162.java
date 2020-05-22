Iterator iterA = filaA.listIterator();
        Iterator iterB = filaB.listIterator();
        Long n = (Long)iterA.next();
        Long m = (Long)iterB.next();
        while (true) {
            if (n <= m) {
                filafusion.add(n);
                if(iterA.hasNext()){
                    n = (Long)iterA.next();
                }
                else{
                    filafusion.add(m);
                    while(iterB.hasNext()){
                        filafusion.add((Long)iterB.next());
                    }
                    break;
                }
            } else {
                filafusion.add(m);
                if(iterB.hasNext()){
                    m = (Long)iterB.next();
                }
                else{
filafusion.add(n);
                    while(iterA.hasNext()){
                        filafusion.add((Long)iterA.next());
                    }
                    break;
                }

            }
        }
        Iterator iterfusion = filafusion.listIterator();
        while (iterfusion.hasNext()) {
            System.out.println(iterfusion.next());
        }