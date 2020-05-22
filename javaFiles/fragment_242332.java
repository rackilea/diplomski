@InputConfig(methodName="input")
public String save(){
    if(empModel.getUuid() == null ){
        empEbi.save(empModel,roleUuids);
    }else{
        empEbi.update(empModel,roleUuids);
    }
    return TO_LIST;
}