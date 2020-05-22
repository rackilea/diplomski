public class ZooType {
    protected List<Element> animals;
    public ZooType(){
    }

    @XmlAnyElement
    public List<Element> getAnimals(){
        if( animals == null ) animals = new ArrayList<Element>();
        return animals;   
    }
    public void setAnimals( List value ){
        animals = value;
    }
}