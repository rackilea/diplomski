ArrayList<ArrayList<String>> stylistIDArray;
ArrayList<ArrayList<String>> durationArray;
stylistIDArray = differentGenderServicesAdapter.getSelectedStylistIdArray();
durationArray = differentGenderServicesAdapter.getSelectedDurArray();

ArrayList<String> stylistId = new ArrayList<>();
ArrayList<String> duration = new ArrayList<>();

for(ArrayList<String> l : stylistIDArray) {
    for(String s : l) {
        stylistId.add(s);
    }
}
for(ArrayList<String> l : durationArray ) {
    for(String s : l) {
        duration.add(s);
    }
}