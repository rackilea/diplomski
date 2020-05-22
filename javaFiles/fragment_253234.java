LinearLayout layout;
        View view;
        for (int i = 0; i < layout.getChildCount(); i++) {
            if(layout.getChildAt(i) instanceof Button){
                ((Button)layout.getChildAt(i)).setVisibility(View.GONE);
            }

        }