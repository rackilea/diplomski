List<Integer> list = new ArrayList<Integer>(){
    public boolean add(Integer add){
    if(super.size()==0 || super.get(super.size()-1)!=add)
        super.add(-1);
    super.add(add);
    return true;
    }
};