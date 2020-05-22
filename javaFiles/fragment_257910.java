public void SaveMessage(final String message){
handler = new Handler(Looper.getMainLooper());
    final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            final Realm realm = Realm.getDefaultInstance();
            realm.executeTransactionAsync(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    SimpleDateFormat simpleDateFormatTime = new SimpleDateFormat("YY/MM/dd HH:mm", Locale.getDefault());
                    String strTime = simpleDateFormatTime.format(new Date());
                    Number currentIdNum = realm.where(MessagePojo.class).max("id");
                    int nextId;
                    if (currentIdNum == null) {
                        nextId = 1;
                    } else {
                        nextId = currentIdNum.intValue() + 1;
                    }
                    MessagePojo messagePojo = realm.createObject(MessagePojo.class,nextId);
                    messagePojo.setDate(strTime);
                    messagePojo.setMessage(message);
                    realm.insertOrUpdate(messagePojo); // using insert AP
                   // EventBus.getDefault().postSticky(true);
                }},
                    new Realm.Transaction.OnSuccess() {
                        @Override
                        public void onSuccess() {
                            Log.e("service", "onSuccess: " );
                            realm.close();
                        }
                    },new Realm.Transaction.OnError() {
                     @Override
                      public void onError(Throwable error) {
                         Log.e("service", "onError: ",error );
                     }}
            );
           //handler.postDelayed(this, 500);

        }
    };
    handler.postDelayed(runnable, 500);
 }