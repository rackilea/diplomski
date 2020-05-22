public void onClick(View v) {
            Random randomNumberGenerator = new Random();
            int number = randomNumberGenerator.nextInt(5);
            ballDisplay.setImageDrawable(this,
                   getDrawable(ballArray[number]));
            }