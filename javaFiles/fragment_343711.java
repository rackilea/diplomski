for (int i = 0; i < friends.size(); i++)
{
    Profile profile = friends.get(i);
    if (profile != null)
    {
        /** Either find an existing view like this: **/

        // You're assembling a resource ID here.
        String resourceName = "profile_" + profile.getId(); // Assuming you have an ID.
        int resourceId = getResources().getIdentifier(resourceName, "id", getActivity().getPackageName());

        // Use it to get the image view in your activity's layout.
        ImageView imageView = (ImageView) findViewById(resourceId);
        if (imageView != null)
        {
            Picasso
                    .with(this)
                    .load(profile.getUserImageUrl())
                    .into(imageView);
        }

        /** Or inflate a View like this: **/

        // Get a containing view. You should move this above your
        // loop--it's here so I can keep these blocks together.
        FrameLayout frameLayout = (FrameLayout) findViewById(R.layout.frame_layout);

        // This is a layout that contains your image view and
        // any other views you want associated with a profile.
        View view = LayoutInflater.from(this).inflate(R.layout.profile_layout, null, false);

        // You're finding the view based from the inflated layout, not the activity layout
        ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
        if (imageView != null)
        {
            Picasso
                    .with(this)
                    .load(profile.getUserImageUrl())
                    .into(imageView);
        }

        frameLayout.addView(view);
    }
}