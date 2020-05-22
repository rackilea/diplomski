@Override
public void recyclerviewOnUpdate(int amount) {
    //Now I can get the int and check if the adapter is empty after removing a item
    if (amount<1) {
        txtEmptyAdapter.setVisibility(View.VISIBLE);
    }
}