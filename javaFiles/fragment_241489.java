private Pair<CustomClass, Integer> myMethod(CustomClass custom, Integer discount) {

    int dis = discount - custom.getAmount;
    pair.getKey().add(custom.setAmount(custom.getAmount - discount))
    pair.getValue().add(dis);

    if (dis <= 0)
    {
       return pair;
    }

    return myMethod (custom, dis);

}