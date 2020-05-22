ArrayList<Model> arrayModel = new ArrayList<Model>();

      for(int i=0;i<arrayOne.size();i++)
   {
        Model model=new Model();
        model.setName(arrayOne.get(i));
        model.setDesc(arrayTwo.get(i));
        arrayModel.add(model);
   }