class MyOnClickListener implements OnClickListener {
    private final int rowIndex;
    MyOnClickListener(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    @Override
    public void onClick(View v) {
        // do something with rowIndex
    }
}