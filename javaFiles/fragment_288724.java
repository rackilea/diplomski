textView.post(new Runnable()
    {
        public void run()
        {
            textView.setText(String.valueOf(view.getHeight()));
        }
    });