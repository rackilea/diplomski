ListIterator<Integer> it = li.listIterator(z);       
        while(it.hasPrevious()){
            //System.out.print(it.previous() + " ");
            int k = it.previous();
            System.out.print(k + " ");
            li2.add(k);
        }

        /**
            Now that I have filled li2, I create my ListIterator it2.
        **/
        ListIterator<Integer> it2 = li2.listIterator();  
        while(it2.hasNext()){
            int p = it2.next();
            System.out.print(p + " ");
        }