final FragmentManager manager = getSupportFragmentManager();

CustomDateTimePicker custom = new CustomDateTimePicker(getActivity(),
        new CustomDateTimePicker.ICustomDateTimeListener() {

             ... 
             Fragment stf = new SnailTrailFragment();
             manager.beginTransaction()
                .replace(R.id.mainLayout, stf)
                .commit();