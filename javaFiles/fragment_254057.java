int[] colors = {Color.WHITE, Color.BLUE, Color.RED };

  bt1.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            Integer tag = (v.getTag() == null) ? 0 : (Integer)v.getTag();
            int color = colors[tag];
            dc1.setTextColor(color);
            v.setTag((tag+1)%colors.length);
        }
    });