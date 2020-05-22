@Override
    public void connectIt(String time) {

        Details details = Details.newInstance(time);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        fragmentTransaction.replace( R.id.frameLayout , details );

        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();

    }