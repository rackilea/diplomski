ArrayList<Integer> f2Child1=new ArrayList<Integer>();
    f2Child1.add(R.drawable.birds);
    f2Child1.add(1);
    flags2.add(f2Child1);

    ArrayList<Integer> f2Child2=new ArrayList<Integer>();
    f2Child2.add(R.drawable.aquatic);
    f2Child2.add(0);
    flags2.add(f2Child2);

    listOfFlags.add(flags1);
    listOfFlags.add(flags2);

    final List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
    final  String[] from = { "flag"};
    final  int[] to = { R.id.flag};