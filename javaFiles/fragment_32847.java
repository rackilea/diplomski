private void filter(String text) {
        if (text.length() == 0) {
            adapter.filterList(stationList);
        } else {
            ArrayList<Station> filteredList = new ArrayList<>();

            for (Station item : stationList) {
                if (item.getData().getCity().toLowerCase().contains(text.toLowerCase())) {
                    filteredList.add(item);
                }
            }

            adapter.filterList(filteredList);
        }
    }