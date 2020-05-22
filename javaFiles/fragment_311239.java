@Override 
public int getItemCount() { 
    if(userDataStore == null){return 0;}

     if(!userDataStore.getDataStore().isEmpty()&&userDataStore.getDataStore()!=null) {
            return userDataStore.getDataStore().size();
    } else{

            return 0;  
    }
 }