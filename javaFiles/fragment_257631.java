button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int result = 4 + 4;
            fragBeamRec.onCalculationComplete(result);
        }
    });