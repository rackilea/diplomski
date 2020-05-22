public void RemovePet(String maXoa) {    
     Iterator<Pet> iter=listPet.iterator();
     while(iter.hasNext()){
        Pet p=iter.next()
        if(maXoa.equals(p.id)){
            iter.remove();
        }
    }
}