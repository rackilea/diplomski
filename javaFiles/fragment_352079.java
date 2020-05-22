while(it.hasNext() && it2.hasNext()) {
        String str = it2.next();
        System.out.println(str);
        if(it.next().getLine().contains(str)) {
            //it.remove();
        }
    }