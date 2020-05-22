MainFragment fragment = new MainFragment ();
            fragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager()
              .beginTransaction()
              .replace("your fragment container id here", fragment)
              .commit();