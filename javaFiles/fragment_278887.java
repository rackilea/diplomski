z:
        System.out.println(o + "  x is this  : ");
        for(int x = 2; x < 7; x++) {
            if(x==3) continue;
            if(x==5) break z;
            o = o + x;
        }