//add todayHistoryItem == null check
if (todayHistoryItem == null || todayHistoryItem.getMood() == null) {
        relativeLayout.setBackgroundColor(0);
    }  else {
        // Set background color and fraction for each mood case
        switch (todayHistoryItem.getMood()) {
            case Sad:
                relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(width / 5,
                        LinearLayout.LayoutParams.MATCH_PARENT, 1));
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.faded_red));
                break;
        case Disappointed: etc....