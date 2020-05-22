Handler handler1 = new Handler();

for (int i = 0; i < separated.length; i++) {
    final int iDupe = i;
    handler1.postDelayed(new Runnable() {

        public void run() {

            iv = (ImageView) findViewById(imageViews[iDupe]);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(100, 100);
            iv.setLayoutParams(layoutParams);


            if(pol.map_a.containsKey(separated[iDupe].toLowerCase())) {
                iv.setImageResource(pol.map_a.get(separated[iDupe].toLowerCase()));
            }
            else if(pol.map_b.containsKey(separated[iDupe].toLowerCase())) {
                iv.setImageResource(pol.map_b.get(separated[iDupe].toLowerCase()));
            }
            else if(pol.map_c.containsKey(separated[iDupe].toLowerCase())) {
                iv.setImageResource(pol.map_c.get(separated[iDupe].toLowerCase()));
            }
            else if(pol.map_d.containsKey(separated[iDupe].toLowerCase())) {
                iv.setImageResource(pol.map_d.get(separated[iDupe].toLowerCase()));
            }
            else if(pol.map_e.containsKey(separated[iDupe].toLowerCase())) {
                iv.setImageResource(pol.map_e.get(separated[iDupe].toLowerCase()));
            }
        }
    }, i * 1000);
}