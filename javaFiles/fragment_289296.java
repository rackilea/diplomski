final int[] clickableIds = new int[]{
            R.id.easy_mode_button,
            R.id.hard_mode_button,
            R.id.show_achievements_button,
            R.id.show_leaderboards_button,
            R.id.sign_in_button,
            R.id.sign_out_button
    };

    for (int clickableId : clickableIds) {
        view.findViewById(clickableId).setOnClickListener(this);
    }