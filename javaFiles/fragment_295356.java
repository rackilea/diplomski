Handler visibilityToggler = new Handler();


        Runnable visivilityRunnable = new Runnable() {
            @Override
            public void run() {

                 // isUserClickedButton is used to keep record if user has pressed button within 1 sec
                //  keep isUserClickedButton = true for first time as it will run 
                if (!isUserClickedButton) {

                    // user not pressed button
                    Toast.makeText(context,"You are not pressed the Button",Toast.LENGHT_LONG).show();
                }

                // toggle visibility
                Random generator = new Random();
                number = generator.nextInt(16);

                for (int i = 0; i < buttons.length; i++) {
                    if (i == number)
                        buttons[i].setVisibility(View.VISIBLE);
                    else
                        buttons[i].setVisibility(View.INVISIBLE);
                }

            // again start the visibility 
              visibilityToggler.postDelayed(visivilityRunnable,1000);

                // make it false as visibility is toggled and we want to track button pressed from start
                isUserClickedButton = false;


            }
        };

visibilityToggler.postDelayed(visivilityRunnable,1000);