AsyncSession asyncSession = App.getInstance().daoSession.startAsyncSession();
    asyncSession.setListener( new AsyncOperationListener() {
        @Override
        public void onAsyncOperationCompleted(AsyncOperation operation) {
            // do whats needed
        }
    });
    asyncSession.insert(MyObject);