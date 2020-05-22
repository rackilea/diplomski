static void addToMap(DetailedData d){
    DataIdentity identity = new DataIdentity();
    identity.Company = d.Company;
    identity.Category = d.Category;
    identity.ImageType = d.ImageType;
    identity.Model = d.Model;

    DataValue value = new DataValue();
    if(set.containsKey(identity)){
        value = set.get(identity);
    }

    if(d.ImageType == "Header"){
        value.ImageBuffer1 = d.ImageBuffer1;
    }
    else if(d.ImageType == "Thumbnail"){
        value.ImageBuffer2 = d.ImageBuffer1;
    }
    set.put(identity, value);
}

static ArrayList<DetailedData> generateList(){
    ArrayList<DetailedData> list = new ArrayList<Aatish.DetailedData>();
    for(Entry<DataIdentity, DataValue> e : set.entrySet()){
        DetailedData data = new DetailedData();
        DataIdentity di = e.getKey();
        data.Category = di.Category;
        data.Company = di.Company;
        data.ImageType = di.ImageType;
        data.Model = di.Model;

        DataValue dv = e.getValue();
        data.ImageBuffer1 = dv.ImageBuffer1;
        data.ImageBuffer2 = dv.ImageBuffer2;
        list.add(data);
    }
    return list;
}

HashMap<DataIdentity,DataValue> set;

class DetailedData {

    String Company;
    String Model;
    String Category;
    String ImageType;
    String ImageBuffer1;
    String ImageBuffer2;

    @Override
    public String toString() {
        return "[" + Company + "," + Model + "," + Category + "," + ImageType
                + "," + ImageBuffer1 + "," + ImageBuffer2 + "]";
    }

}

static class DataIdentity{
    String Company;
    String Model;
    String Category;
    String ImageType;
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((Category == null) ? 0 : Category.hashCode());
        result = prime * result
                + ((Company == null) ? 0 : Company.hashCode());
        result = prime * result + ((Model == null) ? 0 : Model.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DataIdentity other = (DataIdentity) obj;
        if (Category == null) {
            if (other.Category != null)
                return false;
        } else if (!Category.equals(other.Category))
            return false;
        if (Company == null) {
            if (other.Company != null)
                return false;
        } else if (!Company.equals(other.Company))
            return false;
        if (Model == null) {
            if (other.Model != null)
                return false;
        } else if (!Model.equals(other.Model))
            return false;
        return true;
    }       


}

static class DataValue{
    String ImageBuffer1;
    String ImageBuffer2;
}