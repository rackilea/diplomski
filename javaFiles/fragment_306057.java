ArrayList<ACompanyForSearchResult> filtered = new ArrayList<ACompanyForSearchResult>();

        for (ACompanyForSearchResult town : tempList) {

            if (town.getTownName().equals(name)) {
                filtered.add(town);
            }
        }

        tempList.clear();
        tempList.addAll(filtered);
        listAdapter.notifyDataSetChanged();