class SuperSample { }
    class Sample extends SuperSample { }
    ...
    ArrayList<Sample> sList = new ArrayList<Sample>();
    Object o = sList;
    ArrayList<SuperSample> ssList = (ArrayList<SuperSample>)o;