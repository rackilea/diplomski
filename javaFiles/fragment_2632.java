mArrayAdapter.getFilter().filter(searchQuery, new Filter.FilterListener() {
    @Override
    public void onFilterComplete(int count) {
        if (count == 0){
            Toast.makeText(MainActivity.this, "0 item", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, String.format("Items: %d", count), Toast.LENGTH_SHORT).show();
        }
    }
});