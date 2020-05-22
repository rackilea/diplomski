ParseUser.getCurrentUser();
        ParseUser.logOut();
        Intent i = new Intent(getActivity(), NewHomeActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        getActivity().startActivity(i);
        getActivity().finish();