content2.setOnClickListener(new View.OnClickListener(){
        ...

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(@NonNull Realm realm) {
                        final dbRealm getPoints = realm.where(dbRealm.class).findFirst();
                        RealmList<Long> points = getPoints.getPoints();
                        points.clear();
                        points.add(hit[0]);
                    }
                });

    removebut.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(@NonNull Realm realm) {
                     final dbRealm getPoints = realm.where(dbRealm.class).findFirst();
                     RealmList<Long> points = getPoints.getPoints();
                     points.clear();
                }
           });
       }