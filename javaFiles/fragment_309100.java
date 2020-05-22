manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
@Override
public int getSpanSize(int position) {
    if (position == 0) {
        return 2; //  Splitting into 2 columns
    } else {
        return 3; // Splitting into 3 columns
    }
}