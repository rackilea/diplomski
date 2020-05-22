public static void setTheBackground(Context context, String background_choice, LinearLayout layout){
        if (background_choice == "blue_glass"){
            layout.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.blue_glass));
        } else if (background_choice == "blue_oil_painting")


             //etc... with more backgrounds
        }
        layout.requestLayout();
     }