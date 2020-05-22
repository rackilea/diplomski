for (int i = 0; i < choice.length; i++) {
    if (choice[i].equals(typesList.getItemAtIndex(i).getValue().toString())) {
        typesList.setSelectedItem(typesList.getItemAtIndex(i));
    } else {
      // DEBUG CODE
      System.out.printf("Expected: %s, found: %s%n", typesList.getItemAtIndex(i).getValue().toString());
}