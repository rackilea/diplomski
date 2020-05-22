public void DataInserted(){

    for(int i=0;i<5;i++){

        ModulData modulData= new ModulData();
        modulData.setName("name1 " +i);

        mNotes.add(modulData);
        adpterSearch.notifyItemInserted(i);;
    }
 }