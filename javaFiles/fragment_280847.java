List assetClassCorrelationMatrix = new ArrayList();

    int a=2, b=4;

    List m1 = new ArrayList();
    List m2 = new ArrayList();        

    // inserting values
    m2.add(0, 1.1); 
    m2.add(1, 2.0);
    m2.add(2, 0.5);
    m2.add(3, 0.8979);

    assetClassCorrelationMatrix.add(m1);
    assetClassCorrelationMatrix.add(m2);

    List list = (List) assetClassCorrelationMatrix.get(a-1);
    Number number = (Number) list.get(b-1);
    System.out.println("List = " + a + " and index = " + b + " and the number = " + number);