button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                 Navigation.findNavController(view).navigate(R.id.nav_home_to_nav_collection);
            }
        });