public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("active",active);
        saveBooleanToPreferences("active",active);
    }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            if(savedInstanceState!=null)
            {

                active=getBooleanFromPreferences("active")
                if(attivo==true)
                {
                    Toast.makeText(getActivity(),"True",Toast.LENGTH_SHORT).show();
                }
                else
                {
                   Toast.makeText(getActivity(),"False",Toast.LENGTH_SHORT).show();

                }
            }