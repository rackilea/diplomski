OnClickListener listener = new OnClickListener() {
    public void onClick(View v) {
        int cellId = (int) v.getTag();
        cellClicked(cellId, v);
    }
}

View v;
for (int i = 0; i < 20; i++) {
    v = findViewById(cellIDs[i]);
    v.setOnClickListener(listener);
    v.setTag(i);
}