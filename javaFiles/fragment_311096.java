Spinner maritalSpinner = (Spinner) view.findViewById(R.id.marital_spinner);
    List<MaritalStatus> maritalStatusList = new ArrayList<>();
    List<String> maritalStatusArray = new ArrayList<>();
    maritalStatusList = dbConnection.getMaritalStatus(maritalStatusDao);
    maritalStatusArray.clear();
    maritalIdArray.clear();
    maritalStatusArray.add("~Select~");
    maritalIdArray.add(0l); // this is number '0' and alphabet 'l'(small 'L') not number '1'
    for (MaritalStatus marital : maritalStatusList) {
        String maritalStatus = marital.getMaritalStat();
        long maritalId = marital.getMaritalId();
        maritalStatusArray.add(maritalStatus);
        maritalIdArray.add(maritalId);
    }
    maritalAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, maritalStatusArray);
    maritalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    maritalAdapter.notifyDataSetChanged();
    maritalSpinner.setAdapter(maritalAdapter);