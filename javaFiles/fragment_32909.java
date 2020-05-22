for(Object i : set)
        if(i.equals(1)) {
            set.remove(i);
            set.add(1337);
            break;
        }