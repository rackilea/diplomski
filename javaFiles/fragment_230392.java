while (titleText.getLineCount() > 1) {
        float scaledDensity = ManagerStorage.mainActivity.getResources().getDisplayMetrics().scaledDensity;
        titleText.setTextSize(titleText.getTextSize() / scaledDensity - 0.5f);

        titleText.post(new Runnable() {
            @Override
            public void run() {
                int lineCount = titleText.getLineCount();
                Log.i("lines", "" + titleText.getLineCount());
                // Use lineCount here
            }
        });
    }