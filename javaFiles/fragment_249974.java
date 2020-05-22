try{
    View view = navigationView.getMenu().findItem(R.id.nav_1).getActionView();
            Button button = (Button) view.findViewById(R.id.button);
             //button.setOnClickListener(this);
             // similarly for others menu in BottomNavigationView
        } catch (Exception e) {
            AppLogger.getInstance().writeException(e);
        }