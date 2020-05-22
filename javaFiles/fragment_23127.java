System.out.println("0-29  30-39  40-69  70-100");      

    for(int v = 0; v<countertwo||v<counterthree||v<counterfour||v<counterfive;) {

        if (countertwo>0 && counterthree>0 && counterfour>0 &&counterfive>0) {
            System.out.println(" *      *      *      *");
            countertwo--; counterthree--; counterfour--; counterfive--;
        }
        if (countertwo>0 && counterthree>0 && counterfour>0 &&counterfive==0) {
            System.out.println(" *      *      *");
            countertwo--; counterthree--; counterfour--;
        }
        if (countertwo>0 && counterthree>0 && counterfour==0 &&counterfive>0) {
            System.out.println(" *      *             *");
            countertwo--; counterthree--; counterfive--;
        }
        if (countertwo>0 && counterthree>0 && counterfour==0 &&counterfive==0) {
            System.out.println(" *      *              ");
            countertwo--; counterthree--;
        }
        if (countertwo>0 && counterthree==0 && counterfour>0 &&counterfive>0) {
            System.out.println(" *             *      *");
            countertwo--; counterfour--; counterfive--;
        }
        if (countertwo>0 && counterthree==0 && counterfour>0 &&counterfive==0) {
            System.out.println(" *             *       ");
            countertwo--; counterfour--;
        }
        if (countertwo>0 && counterthree==0 && counterfour==0 &&counterfive>0) {
            System.out.println(" *                    *");
            countertwo--; counterfive--;
        }
        if (countertwo>0 && counterthree==0 && counterfour==0 &&counterfive==0) {
            System.out.println(" *                     ");
            countertwo--;
        }
        if (countertwo==0 && counterthree>0 && counterfour>0 &&counterfive>0) {
            System.out.println("        *      *      *");
            counterthree--; counterfour--; counterfive--;
        }
        if (countertwo==0 && counterthree>0 && counterfour>0 &&counterfive==0) {
            System.out.println("        *      *       ");
            counterthree--; counterfour--;
        }
        if (countertwo==0 && counterthree>0 && counterfour==0 &&counterfive>0) {
            System.out.println("        *             *");
            counterthree--; counterfive--;
        }
        if (countertwo==0 && counterthree>0 && counterfour==0 &&counterfive==0) {
            System.out.println("        *              ");
            counterthree--;
        }
        if (countertwo==0 && counterthree==0 && counterfour>0 &&counterfive>0) {
            System.out.println("               *      *");
            counterfour--; counterfive--;
        }
        if (countertwo==0 && counterthree==0 && counterfour>0 &&counterfive==0) {
            System.out.println("               *       ");
            counterfour--;
        }
        if (countertwo==0 && counterthree==0 && counterfour==0 &&counterfive>0) {
            System.out.println("                      *");
            counterfive--;
        }
        if (countertwo==0 && counterthree==0 && counterfour==0 &&counterfive==0) {
            System.out.println("                       ");   
        }
    }