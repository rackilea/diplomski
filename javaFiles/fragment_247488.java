public class CustomOnClickListener implements OnClickListener {
    int clicked = 0 ;

    @Override
    public void onClick(View v) {
        // here comes View, not ImageButton, so you should check if it is ImageButton and then set tint
        if (v instanceof ImageButton) {
            ((ImageButton)v).setColorFilter(Color.argb(150, 255, 255, 255));
        }

        // PART YOU ARE INTERESTED IN
        clicked++;
        Intent intent = new Intent(v.getContext(), Someclass.class);
    }
}