// method in RealmManager
public final void runTransaction(Realm.Transaction transaction) {
    runTransaction(transaction, null, null);
}

public final void runTransaction(Realm.Transaction transaction, Realm.Transaction.OnSuccess onSuccess) {
    runTransaction(transaction, onSuccess, null);
}

public final void runTransaction(Realm.Transaction transaction, Realm.Transaction.OnSuccess onSuccess, Realm.Transaction.OnError onError) {
    Realm realm = openLocalInstance();
    if(realm.isAutoRefresh()) {
        realm.executeTransactionAsync(transaction, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                try {
                    if(onSuccess != null) {
                        onSuccess.onSuccess();
                    }
                } finally {
                    closeLocalInstance();
                }
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable e) {
                try {
                    if(onError != null) {
                        onError.onError(e);
                    }
                } finally {
                    closeLocalInstance();
                }
            }
        });
    } else {
        try {
            realm.executeTransaction(transaction);
            if(onSuccess != null) {
                onSuccess.onSuccess();
            }
        } catch(Exception e) {
            if(onError != null) {
                onError.onError(e);
            }
            throw new RuntimeException(e);
        } finally {
            closeLocalInstance();
        }
    }
}