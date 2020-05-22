public void syncList(final List<String> localData) {
   //fetch the server data

         Observable<Map<String, List<String>>> syncResultObservable = serverDataDownloadObservable(userid)
        .flatMap(new Func1<String[], Observable<Map<String, List<String>>>>() {
            @Override
            public Observable<Map<String, List<String>>> call(String[] serverData) {
                Map<String, List<String>> map = syncResult(localData, Arrays.asList(serverData));
                return Observable.just(map);
            }
        }).subscribeOn(Schedulers.io())
            .subscribe(new Action1<Map<String, List<String>>>() {
                @Override
                public void call(Map<String, List<String>> stringListMap) {
                    List<String> toAdd = stringListMap.get("toAdd");
                    if (toAdd != null && toAdd.isEmpty() == false) {
                    } else {
                        addRecords(toAdd);
                    }
                    List<String> toRemove = stringListMap.get("toRemove");
                   if (toRemove != null && toRemove.isEmpty() == false) {
                        removeRecords(toRemove);
                    }
                }
            });

}