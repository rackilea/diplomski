@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mAuth = FirebaseAuth.getInstance();


    mtoolbar = (Toolbar) findViewById(R.id.mainpagetoolbar);
    setSupportActionBar(mtoolbar);
    getSupportActionBar().setTitle("Home");

    drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
    drawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, R.string.drwaer_open, R.string.drawer_close);
    drawerLayout.addDrawerListener(drawerToggle);
    drawerToggle.syncState();
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    navigationView = (NavigationView) findViewById(R.id.navigation);
    View view = navigationView.inflateHeaderView(R.layout.navigation_header);
    navProfileImage = (CircleImageView) view.findViewById(R.id.user_photo);
    navProfileUserName = (TextView) view.findViewById(R.id.username);


    postList = (RecyclerView) findViewById(R.id.users_posts);

    if(mAuth.getCurrentUser()!=null){

        currentUserId = mAuth.getCurrentUser().getUid();

        userRef = FirebaseDatabase.getInstance().getReference().child("Users").child(currentUserId);
        userRef.child(currentUserId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {


                    if (dataSnapshot.hasChild("fullname")) {
                        String fullname = dataSnapshot.child("fullname").getValue().toString();
                        navProfileUserName.setText(fullname);
                    }

                    if (dataSnapshot.hasChild("profileimage")) {
                        String image = dataSnapshot.child("profileimage").getValue().toString();


                        Picasso.with(MainActivity.this).load(image).placeholder(R.drawable.profile).into(navProfileImage);
                    }


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            UserMenuSelector(item);
            return false;
        }
    });

}

@Override
protected void onStart() {
    super.onStart();

    FirebaseUser currrentUser = mAuth.getCurrentUser();
    if (currrentUser == null) {
        sendUsertoLoginActivity();
    } else {
        CheckUserExistance();
    }
}

private void CheckUserExistance() {
    FirebaseUser user = mAuth.getCurrentUser();
    if (user != null) {
        // User is signed in
        final String user_id = user.getUid();
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (!dataSnapshot.hasChild(user_id)) {
                    sendUserToSetUpActivity();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    } else {
        // User is not signed in
        // Do some stuff
    }
}

private void sendUserToSetUpActivity() {
    Intent setupIntent = new Intent(MainActivity.this, SetupActivity.class);
    setupIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
    startActivity(setupIntent);
    finish();
}

private void sendUsertoLoginActivity() {
    Intent loginIntent = new Intent(MainActivity.this, SignInActivity.class);
    loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
    startActivity(loginIntent);
    finish();
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    if (drawerToggle.onOptionsItemSelected(item)) {
        return true;
    }
    return super.onOptionsItemSelected(item);
}

private void UserMenuSelector(MenuItem item) {

    switch (item.getItemId()) {
        case R.id.nav_Profile:
            Toast.makeText(this, "profile ", Toast.LENGTH_SHORT).show();
            break;
        case R.id.nav_home:
            Toast.makeText(this, "Home ", Toast.LENGTH_SHORT).show();
            break;


        case R.id.nav_find_friends:
            Toast.makeText(this, "Find Friends", Toast.LENGTH_SHORT).show();
            break;

        case R.id.nav_messeages:
            Toast.makeText(this, "Messages", Toast.LENGTH_SHORT).show();
            break;

        case R.id.nav_settings:
            Toast.makeText(this, "Settings ", Toast.LENGTH_SHORT).show();
            break;

        case R.id.nav_friends:
            Toast.makeText(this, "friends ", Toast.LENGTH_SHORT).show();
            break;
        case R.id.nav_SignOut:
            mAuth.signOut();
            sendUsertoLoginActivity();
            break;
    }
}