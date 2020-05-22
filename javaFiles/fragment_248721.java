// where fooType was what I wanted to ween out the Foo results on before
    // selecting Bar objects.
    RealmQuery<Foo> fooRealmQuery = realm
            .where(Foo.class)
            .equalTo("fooType", "desired type")
            .or()
            .equalTo("fooType", "other type");
    RealmResults<Foo> fooList = fooRealmQuery.findAll();

    List<Bar> barList = new ArrayList<Bar>();
    for (Foo foo : fooList) {

        Bar bar = foo.getBar();

        if (!barList.contains(bar)) {
            barList.add(bar);
            Log.d(TAG, "added " + bar.getName());
        } else {
            Log.d(TAG, "I already had that bar");
        }
    }

    adapter = new BarAdapter(this, barList);
    listView.setAdapter(adapter);