public void onClick (View view){
        MyApp.addItem(your item);
        Intent i=new Intent(MaterialView.this, MaterialCart.class);
        startActivity(i);
    }


} );