/*for (int i = 0; i < dienos.length; i++) {
        String[] today = dienos[i];
        populateListView(today);
    }*/

    dummyTextView.setText(Integer.toString(getArguments().getInt(
            ARG_SECTION_NUMBER)));
    // instead of the above loop, add this line
     populateListView(dienos[getArguments().getInt(ARG_SECTION_NUMBER)]);// if section_number starts with 1, then dienos[getArguments().getInt(ARG_SECTION_NUMBER)-1]
    return rootView;