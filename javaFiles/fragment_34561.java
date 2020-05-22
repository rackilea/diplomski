InternetUtil.isInternetOn()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( new Action1<Boolean>() {
                @Override
                public void call(boolean isOnline) {
                    if(isOnline){
                    // your mainthread code here
                    }
                }
            });