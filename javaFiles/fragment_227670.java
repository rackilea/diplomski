floatButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           FragmentManager fm = getActivity().getFragmentManager();
           fm.beginTransaction().replace(R.id.content_main, new PostsFragment()).commit();
        }
    });