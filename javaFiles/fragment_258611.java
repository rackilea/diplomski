RestClient.get().getTechnolgies(id)
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe(new Action1<List<Technology>>() {
         @Override
            public void call(List<Technology> technologies) {
                ArrayList<Technology> techList = technologyBL.someLogic(technologies);
                adapterTech=new TechnologyAdapter(this,techList);
                listView.setAdapter(adapterTech);
            }
     });