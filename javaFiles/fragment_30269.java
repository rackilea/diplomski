int size = CruiseList.getModel().getSize();
StringBuilder allCruises = new StringBuilder("All cruises:");
for(int i = 0; i < size; i++) {
    allCruises.append("\n").append(CruiseList.getModel().getElementAt(i));
}
System.out.print(allCruises);