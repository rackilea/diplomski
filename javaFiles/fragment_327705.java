Iterator<String> iter = myArrayList.iterator();

while (iter.hasNext()) {
    String str = iter.next();

    if (someCondition)
        iter.remove();
}