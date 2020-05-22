buttons[i].setOnClickListener(new View.OnClickListener() {
        @Override 
        public void onClick(View v) {
        try{
            startActivity(new Intent(names[x][0]));
        } catch(ActivityNotFoundException e) {
            if (x==1) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id=uk.co.nickfines.RealCalc"));
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException f) {
                }
            }
        }

    });