import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("channel")
public class Channel {

    private String link;

    @XStreamAlias("atom:link")
    private String atom_link;

    private String title;
    private String description;

    private Image image;

     public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAtom_link() {
        return atom_link;
    }

    public void setAtom_link(String atom_link) {
        this.atom_link = atom_link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<String> getItemList() {
        return itemList;
    }

    public void setItemList(List<String> itemList) {
        this.itemList = itemList;
    }

    @XStreamImplicit 
     private List<String> itemList;

}