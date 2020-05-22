public static void searchYear (Indicator indicator, int searchTerm) {
    for (int i = 0; i < indicator.DataList.size(); i++) {
        if (indicator.DataList.get(i).getYear() == searchTerm) { // Sequentially get MyData object from DataList and its year for comparison
            System.out.println("Found year " + searchTerm + " with Indicator code " + indicator.getICode() +  " having value " + indicator.DataList.get(i).getValue());
            return; // Exit this method
        }
    }
    System.out.println("Not Found");
}