RestClient.get().getTechnolgies(id,new CallBack<List<Technolgy>(){
   @Override
   public void success(List<Technology> technologies, Response response) {
        ArrayList<Technology> techList = technologyBL.someLogic(technologies);
        adapterTech=new TechnologyAdapter(this,techList);
        listView.setAdapter(adapterTech);
   }

   @Override
   public void failure(Retrofit error){}
});