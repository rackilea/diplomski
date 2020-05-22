import java.util.HashMap;

public class HelloWorld{
 static class Entity {
    private String name;
    private int countFirst;
    private int countSecond;
    private boolean isVisitedMember; // because we want to print in same order as in original matrix

    public Entity(String name) {
        this.name = name;
        countFirst = 0;
        countSecond = 0;
        isVisitedMember = false;
    }

    public void inc(String status) {
        if (status.toLowerCase().equals("deferred")) {
            ++countFirst;
        }
        else {
            ++countSecond;   
        }
    }

    public boolean isVisited() {
        return isVisitedMember;
    }

    public void setIsVisited(boolean value) {
        isVisitedMember = value;
    }

    public float getFirstPercent() {
        return (float)countFirst / (countFirst + countSecond) * 100;
    }

    public float getSecondPercent() {
        return (float)countSecond / (countFirst + countSecond) * 100;
    }

    @Override
    public String toString() {
        if (countFirst <= countSecond) {
            int first = (int)Math.ceil(getFirstPercent());
            return String.format("%s --> Deferred %d %% , Bounced %d %%", name, first, 100 - first);
        }

        int second = (int)Math.ceil(getSecondPercent());
        return String.format("%s --> Deferred %d %% , Bounced %d %%", name, 100 - second, second);
    }
 }


 public static void main(String []args){
    String[][] data = {
        { "FAI", "deferred" },
        { "SDE", "Bounced" },
        { "FAI", "Bounced" },
        { "SDE", "Bounced" },
        { "SDE", "deferred" },
        { "FAI", "deferred" },
    };

    HashMap<String, Entity> map = new HashMap<String, Entity>();
    for (int i = 0; i < data.length; ++i) {
        String name = data[i][0];
        String value = data[i][1];
        Entity entity = map.get(name);
        if (entity == null) {
            entity = new HelloWorld.Entity(name);
            map.put(name, entity);
        }

        entity.inc(value);
    }

    // print in same order as in original matrix
    for (int i = 0; i < data.length; ++i) {
        String name = data[i][0];
        Entity entity = map.get(name);
        if (entity.isVisited()) {
            continue;
        }

        entity.setIsVisited(true);
        System.out.println(entity);
    }        
 }