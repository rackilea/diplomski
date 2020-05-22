for (int i = 0; i < details.size(); i++) {
    OldDetails cn = details.get(i);
    double num = cn.getWeight();
    int id = cn.getId();
    Log.d("num", "equals: " + num);
    arrayWeight[i] = num;
    arrayId[i] = id; 
}