public boolean alternance(int[] a) {
        boolean isAlternance = true;
        for(int i = 0; i < a.length - 1; i++) {
            if(a[i] * a[i+1] >= 0)
                isAlternance = false;
        }
        return isAlternance; 
    }