if (savedInstanceState == null) {
            lvfrag = new listViewFrag();
            fragmentTransaction.replace(R.id.ll, lvfrag, "lvfrag");
            fragmentTransaction.commit();
        } else {
           // even though savedInstanceState is not null
           // lvfrag still needs to be created
            if(lvfrag.isVisible()){