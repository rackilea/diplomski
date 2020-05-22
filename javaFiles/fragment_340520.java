if(your condition)
        {
            yourtextview.setVisibility(View.GONE);
            yourtextview.setEnabled(false);
            yourtextview.setFocusable(false);
        }

        else
        {
            yourtextview.setVisibility(View.VISIBLE);
            yourtextview.setEnabled(true);
            yourtextview.setFocusable(true);
        }