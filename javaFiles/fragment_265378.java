myVersatileSeekBar.bindDisplayToChange(myTextView, new VersatileSeekBar.ChangeHandler() {
            @Override
            public void onChange(int value, TextView textView) {
                textView.setText("level :" + value * 100);
            }
        });