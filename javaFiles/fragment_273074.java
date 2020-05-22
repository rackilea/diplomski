private class MyResolveListener implements NsdManager.ResolveListener {
        @Override
        public void onResolveFailed(NsdServiceInfo serviceInfo, int errorCode) {
            //your code
        }

        @Override
        public void onServiceResolved(NsdServiceInfo serviceInfo) {
            //your code
        }
    }