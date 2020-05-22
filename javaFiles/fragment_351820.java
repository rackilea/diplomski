final DrawerLayout drawer = findViewById(R.id.drawer_layout);
ImageButton imageButton = findViewById(R.id.backbutton);
imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });