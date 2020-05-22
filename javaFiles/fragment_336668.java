textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
        @Override
        public View makeView() {
            TextView switcherTextView = new TextView(getApplicationContext());
            switcherTextView.setTextSize(24);
            switcherTextView.setTextColor(Color.RED);
            return switcherTextView;
        }
    });