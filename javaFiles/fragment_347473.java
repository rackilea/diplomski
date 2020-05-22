for(String alphabet: amis)
{
    Object[] parts = alphabet.split(",");
    Object studentID = (parts[0]);
    Object a = parts[1];
    Object b = parts[2];
    Object c = (parts[3]);
    Object d = parts[4];
    ArrayList<Object> Compare = new ArrayList();

    Compare.add(a);
    Compare.sort(new customComparator());
}