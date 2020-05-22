LinearLayout layout = new LinearLayout(context);
 switch (position) {
        case 0:
           TextView tv = new TextView(context);
           tv.setText("some text");
           tv.setPadding(5, 5, 5, 5);
           tv.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
           // And so on customize and create as many views as you want. 

           // And finally add them to your layout
          layout.addView(tv);
          return layout;

        case 1:
          .
          .
          .
        case 2:
          .
          .
          .
}