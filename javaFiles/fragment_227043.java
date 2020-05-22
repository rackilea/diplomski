if (adapt == null) {
    adap = new ArrayAdapter<>(
            this,
            android.R.layout.simple_list_item_1,
            dfn
    );
} else {
   adapt.updateItems(dfn);
   adap.notifyDataSetChanged();
}

public void notifyDataChanged() {
    random();
}