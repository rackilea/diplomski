btn3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Double sChicken = 4555.667; // your Double value

        Intent intent = new Intent(ChooseBurger.this,com.example.burgerjoint.ChooseDrinks.class);
        intent.putExtra("chicken",sChicken);
        startActivity(intent);

    }
});