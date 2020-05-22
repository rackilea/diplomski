for (int i=0;i<roman.length();i++) {
        val=value(roman.charAt(i));
        if (i<roman.length()-1) {
            val_next=value(roman.charAt(i+1)); //<--
        }
        System.out.println(val + "\t" + val_next);
    }