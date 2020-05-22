public ArrayList<object1> updateAccountWithGSAM(ArrayList<object1> o1, ArrayList<object2> o2) {
   HashMap<String, ArrayList<String>> reverseMap = new HashMap<String, ArrayList<String>>()
    for (object2 g : o2) {
        if (g.getfield() != null) {
            ArrayList<String> accs1 = reverseMap.get(g.getobject1());
            if(accs1 == null) {
                accs1 = new ArrayList<String>()
                reverseMap.put(g.getobject1(), acc1)
            }
            accs1.add(o2s);
        }
    }
    ArrayList<object1> accs = new ArrayList<object1>();
    for (object1 acc : o1) {
        ArrayList<String> o2s= new ArrayList<String>();
        if(reverseMap.get(acc.getCode()) != null) {
            acc.setGSAM_code(o2s);
            accs.add(acc);
        }
    }

    return accs;
}