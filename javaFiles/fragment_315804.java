List<String[]> data = new ArrayList<String[]>();
int size = parcel.readInt(); // read size
for (int i = 0; i < size; i++) {
    String[] letters = parcel.createStringArray(); // read each element
    data.add(letters);
}