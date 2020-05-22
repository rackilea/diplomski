try {

        Tau = new krigingTau();
        Krig = new krigingTau();
        branin = new Branin();

        resultT = Tau.LPtau(1, 100, 2, 1234);
        List<Object> X = Arrays.asList(resultT[0]);         

        if (X.get(0) instanceof MWNumericArray) {

            MWNumericArray mw= (MWNumericArray) X.get(0);
            ArrayList<Point> lists = new ArrayList<Point>();
            for(int i = 1; i <= mw.numberOfElements()/2; i++){
                Object o = mw.get(i);
                System.out.println(o);
                Double x = (Double) mw.get(i);
                Double y = (Double) mw.get((mw.numberOfElements()/2)+i);
                Point p = new Point(x.doubleValue(),y.doubleValue());
                lists.add(p);
            }

            for(int i = 1; i < mw.numberOfElements()/2; i++)
            {

                resultB = branin.branin(1, lists.get(i).array);
                System.out.println(resultB[0]);
            }