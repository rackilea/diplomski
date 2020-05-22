Dialog d = DialogAbout.create(this);
            Button b = findViewById(R.id.pick_button);
            // Absolute coordinates
            int[] location = new int[2];
            b.getLocationOnScreen(location);
            int x = location[0];
            int y = location[1];

           // Coordinates relative to parent
            int bx = b.getLeft();
            int by = b.getTop();

            Window window = d.getWindow();

            WindowManager.LayoutParams wlp = window.getAttributes();
            // set the new location [you will need to play with this]
            wlp.x = x;
            wlp.y = (y - b.getHeight());

            // add to your window
            window.setAttributes(wlp);