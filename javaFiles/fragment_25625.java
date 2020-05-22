private String[] mostlyMatchedKeywordsStrings;
        mostlyMatchedKeywordsStrings = searchResponse.getData().getMostlyMatchedKeywordsText();
        cloudChipList.clear();
        fullSearchMini_chipCloud.removeAllViews();

    for (int i = 0; i < mostlyMatchedKeywordsStrings.length; i++) {

        cloudChipList.add(mostlyMatchedKeywordsStrings[i]);

        if (i >= mostlyMatchedKeywordsStrings.length - 2) {
            fullSearchMini_didYouMeanLay.setVisibility(View.VISIBLE);
        } else {
fullSearchMini_didYouMeanLay.setVisibility(View.GONE);
}


        fullSearchMini_chipCloud.addChip(mostlyMatchedKeywordsStrings[i]);
        Log.e("searchKeys", mostlyMatchedKeywordsStrings[i]);

        fullSearchMini_chipCloud.setChipListener(new ChipListener() {
            @Override
            public void chipSelected(int i) {
                try {
                    Log.e("searchKeys", "new : " + mostlyMatchedKeywordsStrings[i]);

                } catch (Exception e) {
                }
            }

            @Override
            public void chipDeselected(int i) {

            }
        });

    }