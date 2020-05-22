public class Receipt implements Serializable{
    public String referenceNo;
    public byte[]   image;
    public String comments;
    public long   createdOn;
    public long   updatedOn;
    //...
}

//Put the list in the intent
List<Receipt> list = ...
Intent data = new Intent();
data.putExtra("tag", list);

//Read the list from the intent:
list = (List<Receipt>) data.getSerializableExtra("tag");