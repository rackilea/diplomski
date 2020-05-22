@Override
public void onRefresh() {
    new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                if (Update.updateAll(MainActivity.this)) {
                    packages = dao.getPackages(config.getFilter());
                    packagesAux = dao.getPackages(config.getFilter());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.animateTo(packages);
                        }
                    });
                }
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    swipeRefreshLayout.setRefreshing(false);
                }
            });
        }
    }).start();
}