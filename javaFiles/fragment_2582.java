theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        String itemPicked = "Selected: " + String.valueOf(adapterView.getItemAtPosition(position));
        Toast.makeText(MainActivity.this, itemPicked, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        intent.putExtra("newsId", "1");


        String chosen = String.valueOf(adapterView.getItemAtPosition(position));

        if (chosen == "P1") { // doesn't work
            intent.putExtra("name", "p1");
        } else if (chosen.equals("P2")) { // doesn't work
            intent.putExtra("name", "p2");
        }

        MainActivity.this.startActivity(intent);
    }
});