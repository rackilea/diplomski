scrollView.post(new Runnable() {
        @Override
        public void run() {
            scrollView.scrollTo(textView.getRight(), textView.getTop());
        }
    });