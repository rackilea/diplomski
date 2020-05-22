public String getLastItemFromList(ArrayList<String> al) {
    if(al.isEmpty()) {
        return "";
    }
    return al.get(al.size()-1);
}

public int getSizeOfList(ArrayList<String> al) {
    return al.size();
}