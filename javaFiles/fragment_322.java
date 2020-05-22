myDb = new DatabaseHelper(this);
drawer = findViewById(R.id.drawer_layout);
NavigationView navigationView = findViewById(R.id.nav_view);
View header = navigationView.getHeaderView(0);
txtDisplayEmail = (TextView) header.findViewById(R.id.emaildisplay);
txtDisplayEmail.setText(myDb.getEmail());
navigationView.setNavigationItemSelectedListener(this);