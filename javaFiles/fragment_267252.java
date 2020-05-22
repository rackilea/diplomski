public List<TwoNumbers> doStuff(List<TwoNumbers> list) {
    List<TwoNumbers> returnList = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
        boolean flag = true;
        for (int j = i + 1; j < list.size(); j++) {
            if (list.get(i).getNum1() == list.get(j).getNum1() && list.get(i).getNum2() == list.get(j).getNum2()) {
                flag = false;
            }
        }

        if (flag) {
            returnList.add(list.get(i));
        }
    }
    return returnList;
}