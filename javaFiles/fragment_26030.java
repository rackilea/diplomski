void add(Emp emp) {
    if(getOrg()==null){
        setOrg(emp.getCompany());
    }
    addToList(emp.getWorkLog());
    if(getRawData()!=null){
        setRawData(getRawData()+emp.getData());
    }
    else{
        setRawData(emp.getData());
    }
}