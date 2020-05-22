mPreviousButton = (Button) findViewById(R.id.prev_btn);
    mPreviousButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mCurrentIndex--;
            if (mCurrentIndex < 0)
                mCurrentIndex = mShowTipsTextBank.length - 1;
            updateQuestion();
        }
    });