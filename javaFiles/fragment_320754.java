public void rollDice(View view) {

    diceStatus.setText("Rolling...");
    // Note the random is only created once.
    final Random ranNumber = new Random();
    rollButton.setEnabled(false);

    // updates every 100 millis after an initial 100milli delay.
    rollTimer = new CountDownTimer(3000, 100) {
        @Override
        public void onTick(final long millisUntilFinished) {

            diceNumber = ranNumber.nextInt(6) + 1;

            // use same switch statement as original post - sets the dice face.
        }

        @Override
        public void onFinish() {
            rollButton.setEnabled(true);
            showDiceNumber();
        }

    }.start();
}