double weight = 0.0;
Object target = new Integer(4);
int index = 1;
for (Object elem : linkedList) {
    if (elem.equals(target)) {
        weight += Math.pow(p, index);
    }
    index++;
}