for (int i = 0; i < details.size(); i++) {
    OldDetails cn = details.get(i);
    arrayWeight[i] = cn.getWeight();
    arrayId[i] = cn.getId();
    Log.d("num", "equals: " + arrayWeight[i]);
}