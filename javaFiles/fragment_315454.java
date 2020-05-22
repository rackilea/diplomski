for (int i = 0; i < 6; i++) {
        final int temp = i;
        rollView[i].setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
            changeKeepRoll(temp);
        }
    });
  }