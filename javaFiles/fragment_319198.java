ArrayList<ArrayList<Integer>> masterlist = new ArrayList<ArrayList<Integer>>();

ArrayList<Integer> chillist1=
    new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3}));
ArrayList<Integer> chillist2=
    new ArrayList<Integer>(Arrays.asList(new Integer[]{2,3,4}));
ArrayList<Integer> chillist3=
    new ArrayList<Integer>(Arrays.asList(new Integer[]{3,4,5}));


masterlist.add(chillist1);
masterlist.add(chillist2);
masterlist.add(chillist3);