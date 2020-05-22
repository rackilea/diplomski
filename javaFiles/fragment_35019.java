public void search(String name){
    for(int i=0;i<this.getListStd().size();i++){
        if(this.getListStd().get(i).getName().equalsIgnoreCase(name)){
            System.out.println(this.getListStd().get(i).getName());
        }
        else{
            this.getListStd().add(new Student(name));
            System.out.println("not found");
        }
    }
}