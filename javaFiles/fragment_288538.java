String dna1 = "ATGT";
        String dna2 = "GTGA";

        if(dna1.length() != dna2.length()) return;

        boolean [] mutPoint =  new boolean [dna1.length()];
        for( int i = 0; i < dna1.length(); i++) {
            if( dna1.charAt(i) == dna2.charAt(i)) {
                mutPoint[i] = false;
            }
            else {
                mutPoint[i] = true;
            }
        }

        System.out.println(Arrays.toString(mutPoint));