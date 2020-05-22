...
...
...

FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ViewNote.this, EditNote.class);
                intent.putExtra("id", id);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //startActivityForResult(intent, 0);
                startActivity(intent);
            }
        });

...
...
...

@Override
    public void onBackPressed() {

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

        super.onBackPressed();
    }