import java.util.List;

public class GResults {

public String link;
public List<GResults> items;

public String getLink(){
    return link;
}

public List<GResults> getItems(){
    return items;
}

public void setLink(String link){
    this.link = link;
}

public void setGroups(List<GResults> items){
    this.items = items;
}

public void getThing (int i){
    System.out.println(items.get(i));
}

public String toString(){
    return String.format("%s", link);
}

}