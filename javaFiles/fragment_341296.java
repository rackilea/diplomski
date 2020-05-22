if (list1.size() > list2.size()) {
    // definitely not same order
    return false;
}

int list1Index = 0;
for (int i = 0 ; i < list2.size() ; i++) {
    if (Objects.equals(list2.get(i), list1.get(list1Index))) {
        list1Index++;
        if (list1Index == list1.size())  {
            return true;
        }
    }
}
// at the end, list1Index should be the same as list1.size() if list2 is in the same order.
return false;