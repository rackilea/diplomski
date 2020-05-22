int i = 0;
Vector outputVector = new Vector();
for (int p = 0; p < ((Vector)mainVector.get(0)).size(); p++) {
    Vector second = new Vector();
    for (int h = 0; h < mainVector.size(); h++) {
        Vector eachVector = (Vector)mainVector.get(h);
        Object eachElement = eachVector.get(i);
        second.add(eachElement);
    }
    outputVector.add(second);
    i++;
}