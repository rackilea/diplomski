int ROWS =3;
    int COLUMNS=3;
    List<List<Integer>> twoDimArray = new ArrayList<List<Integer>>();//declaration
    for (int i = 0; i < ROWS ; i++) { // cant rows 
        twoDimArray.add(Collections.nCopies(COLUMNS, new Integer(0)));
        //initialized to zero the number of columns you want
    }

    /* Print  */

    for (List<Integer> list : twoDimArray) {
        System.out.println(list);
    }