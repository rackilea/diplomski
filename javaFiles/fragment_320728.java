mAuthListener = new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            FirebaseUser user = firebaseAuth.getCurrentUser();
            if (user != null) {
                mUserId = user.getUid();
                SignUpAboutFragment signUpAboutFragment = new SignUpAboutFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.sign_up_fragment_container, signUpAboutFragment, SIGN_UP_ABOUT_FRAGMENT_TAG);
                ft.addToBackStack(null);
                ft.commit();
            }
        }
};