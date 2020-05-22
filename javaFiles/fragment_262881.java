btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (isStart) {
            // Stop timer
            isStart = false;
        } else {
            // Start timer
            isStart = true;
        }
    }
});