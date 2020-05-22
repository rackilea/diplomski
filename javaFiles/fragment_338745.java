@Override
public void OnImageAvailable(@NonNull Uri uri) {

    /* the Main {@link DrawerLayout} */
    this.mDrawerLayout = this.findViewById(resIdLayout);

    if (! this.mDrawerLayout.isInEditMode()) {

        /* the {@link NavigationView} Drawer Menu */
        this.mNavigationDrawer = this.findViewById(resIdDrawer);

        /* the {@link NavigationView} Drawer Header */
        View header = this.mNavigationDrawer.getHeaderView(0);
        AppCompatImageView photoUrl = header.findViewById(R.id.photoUrl);

        /* setting the photo-url */
        if (this.currentUser != null && this.currentUser.getPhotoUrl() != null) {
            photoUrl.setImageURI(uri);
        }
    }
}