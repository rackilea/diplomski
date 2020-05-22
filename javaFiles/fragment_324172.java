deleteFolderAndSub(int id){
        int childId = findNextChildId(id);
         //Let -1 be that there are no more children
        while (childId!=-1){
        if (checkIfFolder(childId)){
            deleteFolderAndSub(childId);
    //on exiting from above function folder should be empty so it can be deleted without problem
            deleteEmptyFolder(id);
        } else {
            deleteitem(id);
        }
//it should be while loop and we have to find another child inside the loop
        childId = findNextChildId(id)
      }
    }

findNextChildId(int parentId){
   Coursor yourCoursor;
  while(yourCoursor.moveToNext()){
    if (parentId==yourCoursor.getInt("PARENT")){
        yourCoursor.getInt("ID");
    }
  }
}