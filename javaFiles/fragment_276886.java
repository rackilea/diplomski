findViewById(R.id.tab_main).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.e("BottomClickAction","BottomClickAction");
            OneWayFragment fragment = getOneWayFragment();
            if(fragment != null) {
               String data = fragment.getData();
             }
        }
    });