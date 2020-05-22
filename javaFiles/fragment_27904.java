private class AsyncTaskRetro
        extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(Void... voids) {
        try(Realm r = Realm.getDefaultInstance()) {
            Response<Place> response = PlacesAPI.Factory.getInstance().getPlaces().execute();
            Place place = response.body();
            List<Post> posts = place.getPosts();
            r.executeTransaction((realm) -> {
                for(Post post : posts) {
                    RowModel rowModel = new RowModel(post.getNazwa(),
                            Double.parseDouble(post.getSzer()),
                            Double.parseDouble(post.getDlug()));
                    rowModels.add(rowModel);
                }
                String oldName;
                oldName = rowModels.get(0).getName();
                shopsNames.add(rowModels.get(0).getName());

                RowModel rowModelRealm = realm.createObject(RowModel.class);
                for(RowModel rowModel : rowModels) {
                    rowModelRealm.setName(rowModel.getName());
                    rowModelRealm.setLattitude(rowModel.getLattitude());
                    rowModelRealm.setLongitude(rowModel.getLongitude());

                    if(rowModel.getName().equals(oldName)) {
                        continue;
                    }
                    oldName = rowModel.getName();
                    shopsNames.add(rowModel.getName());
                }
            });
            // no need to manually sort if you use RealmBaseAdapter with findAllSorted()
        }
        return null;
    }
}