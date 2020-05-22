public static ArrayList merge(ArrayList a, ArrayList b) {
    int c1 = 0, c2 = 0;
    ArrayList<Integer> res = new ArrayList<Integer>();

    while(c1 < a.size() || c2 < b.size()) {
        if(c1 < a.size())
            res.add((Integer) a.get(c1++));
        if(c2 < b.size())
            res.add((Integer) b.get(c2++));
    }
    return res;
}