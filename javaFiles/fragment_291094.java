public static void findPosNegProd(int n1, int n2, int n3, int n4){

        int positives = 1;
        int negatives = 1;

        if(n1 > 0) positives *= n1;
        if(n2 > 0) positives *= n2;
        if(n3 > 0) positives *= n3;
        if(n4 > 0) positives *= n4;

        {
            if(n1 < 0) negatives *= n1;
            if(n2 < 0) negatives *= n2;
            if(n3 < 0) negatives *= n3;
            if(n4 < 0) negatives *= n4;
        }

        System.out.println("The product of non-negatives = " + positives);
        System.out.println("The product of negatives = " + negatives);
    }