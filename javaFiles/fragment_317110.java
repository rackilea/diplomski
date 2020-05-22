for (int i = 0; i < l.size(); i++) {
        for (int j = 0; j < l.get(i).length; j++) {
            if( l.get(i)[j].equalsIgnoreCase("A")){
                return j;
            }
        }
    }