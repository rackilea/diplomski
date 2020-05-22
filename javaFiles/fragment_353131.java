@Override
public void onNothingSelected() {
    Log.d("Nothing selected", "Nothing selected.");
}

@Override
public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
   Log.d("Entry selected", e.toString());
     Log.d("", "low: " + mChart.getLowestVisibleXIndex() + ", high: "    + mChart.getHighestVisibleXIndex());
  }