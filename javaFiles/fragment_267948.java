Parts parts = (Parts) unmarshaller.unmarshal(file);
System.out.println(parts);

for (int i = 0; i < parts.size(); i++) {
    chosenList.addElement(parts.get(i));
    System.out.println(parts.get(i));
}