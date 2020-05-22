static class BundleRetrievalTask extends AsyncTask<String, Void, Bundle> {

        @Override
        protected Bundle doInBackground(String... strings) {
            return someLongOperationThatFetchesBundle(strings[0]);
        }

        @Override
        protected void onPostExecute(Bundle bundle) {
            super.onPostExecute(bundle);
            MyFacebookTokenCache tokenCache = MyFacebookTokenCache.init(bundle);
            doSomethingWithCache(tokenCache);

        }
    }

    static class MyFacebookTokenCache extends TokenCache {

        private Bundle mBundle;

        public MyFacebookTokenCache(Bundle bundle) {
            mBundle = bundle;
        }

        public static MyFacebookTokenCache init(Bundle bundle) {
            return new MyFacebookTokenCache(bundle);
        }

        @Override
        public Bundle load() {
            return mBundle;
        }

        @Override
        public void save(Bundle bundle) {
            //todo
        }

        @Override
        public void clear() {
            //todo
        }
    }