readData(new MyCallback() {
    @Override
    public void onCallback(Animal animal) {
        Intent intent = new Intent(this, searchActivity.class);
        intent.putExtra("Animal", animal);
        startActivity(intent);
    }
});