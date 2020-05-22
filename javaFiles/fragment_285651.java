@Override
public int getItemCount() {
    if(persons!=null){
        return persons.size();  
    } else{
        return 0;
    }        
}