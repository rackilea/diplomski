//Create an instance of your fragment;
MyFragment frag = MyFragment.newInstance();
//replace the fragment in a normal fragment transaction
getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, frag, "MyFragment Tag")
                //add to the back stack 
                .addToBackStack(f)
                .commit();