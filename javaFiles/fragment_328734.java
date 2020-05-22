class TAPattern{

...
@XmlElement
private List<Result> resultList;
}

public List<Result> getResultList(){
if(resultList==null)
    resultList = new ArrayList<Result>();

 return resultList;
}

@XmlAccessorType(XmlAccessType.FIELD) 
class Result {
....
}