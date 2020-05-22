public void search(String name){
    boolean found = false;
    for(int i=0;i<this.getListStd().size();i++){
        if(this.getListStd().get(i).getName().equalsIgnoreCase(name)){
            System.out.println(this.getListStd().get(i).getName());
            found = true;
        }
    }
    if(! found){
        this.getListStd().add(new Student(name));
        System.out.println("not found");
    }
}