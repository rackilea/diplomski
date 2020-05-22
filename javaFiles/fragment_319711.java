btnStart.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) 
        {

            Random rand = new Random();
            int number = rand.nextInt() % 3;
            if (number == 1) {
                imgRed.startAnimation(animation);
            }
            else if (number == 2) {
                imgGreen.startAnimation(animation);
            }
            else {
                imgBlue.startAnimation(animation);
            }
        }
    });