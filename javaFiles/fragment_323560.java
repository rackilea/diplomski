public void drawLayout() {
    int counter = 0;
    contactWrapperWidth = getResources().getDisplayMetrics().widthPixels;
    contactWrapper.setOrientation(LinearLayout.VERTICAL); 
    // contact wrapper is a linear Layout 
    // use LinearLayout contactWrapper = (LinearLayout) mView
    //          .findViewById(R.id.yourLinearLayout);
    currCounter = 0;
    currWidth = 0;
    isNewLine = false;

    row[currCounter] = new LinearLayout(getActivity());

    @SuppressWarnings("rawtypes")
    Iterator it = button.iterator();

    for (int i = 0; i < button.size(); i++) {
        it.next();
        row[currCounter].setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        currWidth += Integer
                .parseInt(button.get(i).get("width").toString());
        Log.i("Item width ", "i == "
                + button.get(i).get("width").toString());

        // contactWrapper.getw

        if (isNewLine) {
            if (currWidth < contactWrapperWidth) {
                row[currCounter]
                        .addView((View) button.get(i).get("button"));
                if (!it.hasNext()) {
                    contactWrapper.addView(row[currCounter]);
                } else {
                    if (contactWrapperWidth < (currWidth + Integer
                            .parseInt(button.get(i + 1).get("width")
                                    .toString()))) {
                        isNewLine = true;
                        contactWrapper.addView(row[currCounter]);
                        currCounter += 1;
                        row[currCounter] = new LinearLayout(getActivity());
                        currWidth = 0;
                    } else {
                        isNewLine = false;
                    }
                }
            } else {
                isNewLine = true;
                contactWrapper.addView(row[currCounter]);
                currCounter += 1;
                row[currCounter] = new LinearLayout(getActivity());
                currWidth = 0;
            }
        } else {
            if (currWidth < contactWrapperWidth) {
                if (!it.hasNext()) {

                    View view = (View) button.get(i).get("button");
                    row[currCounter].addView((View) button.get(i).get(
                            "button"));
                    contactWrapper.addView(row[currCounter]);
                } else {
                    View view = (View) button.get(i).get("button");

                    row[currCounter].addView((View) button.get(i).get(
                            "button"));
                    if (contactWrapperWidth < (currWidth + Integer
                            .parseInt(button.get(i + 1).get("width")
                                    .toString()))) {
                        isNewLine = true;
                        Logger.show(Log.INFO, "it.hasNext()",
                                "it.hasNext() contactWrapper");
                        contactWrapper.addView(row[currCounter]);
                        currCounter += 1;
                        row[currCounter] = new LinearLayout(getActivity());
                        currWidth = 0;
                    } else {
                        isNewLine = false;
                    }
                }
            } else {
                isNewLine = true;
                contactWrapper.addView(row[currCounter]);
                currCounter += 1;
                row[currCounter] = new LinearLayout(getActivity());
                currWidth = 0;
            }
        }
        counter++;
    }
}