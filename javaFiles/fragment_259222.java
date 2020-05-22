public void filter(String charText) {
    charText = charText.toLowerCase(Locale.getDefault());
    AllData = ArrayData;
    if (charText.length() == 0) {
         ArrayData = AllData;
    } else {
        ArrayData.clear();
        for (String s : AllData) {
            if (s.toLowerCase(Locale.getDefault()).contains(charText)) {
                ArrayData.add(s);
            }
        }
    }
    notifyDataSetChanged();
}