mHomeWatcher = new HomeWatcher(this);
    mHomeWatcher.setOnHomePressedListener(new HomeWatcher.OnHomePressedListener() {
        @Override
        public void onHomePressed() {
            // do something here...
            Log.e("AHSAN", "onHomePressed: ");

            proceed();
        }

        @Override
        public void onHomeLongPressed() {
            Log.e("AHSAN", "onHomeLongPressed: ");

            proceed();

        }