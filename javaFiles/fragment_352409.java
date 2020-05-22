import java.util.Map;

public abstract class ParentClass<T> {
    public Map <String , T > map;
    abstract void extract();
    abstract void validate();

    protected void setMap(Map <String , T > pMap)
    {
        this.map=pMap;
    }
}