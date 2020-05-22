recyclerView.post(new Runnable() {
        @Override
        public void run() {
            gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        }
    });