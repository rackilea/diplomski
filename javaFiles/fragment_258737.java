@Override
protected void onResume() {
    super.onResume();

    Intent intent = getIntent();

    if (intent.hasExtra("FragmentMyTraining")) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.content_frame, new FragmentMyTraining());
        fragmentTransaction.addToBackStack("my");
        fragmentTransaction.commit();
    } else if (intent.hasExtra("FragmentPopularTraining")) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.content_frame, new FragmentPopularTraining());
        fragmentTransaction.addToBackStack("pop");
        fragmentTransaction.commit();
    }
}