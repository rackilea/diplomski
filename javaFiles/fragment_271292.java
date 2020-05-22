customButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(navigationView)) {
                    closeDrawer();
                } else {
                    openDrawer();
                }
            }
        });