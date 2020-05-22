public class AndroidSaxFeedParser extends BaseFeedParser {

    //Store all items with a particular section 
    ArrayList<ItemPojo> itemList = new ArrayList<ItemPojo>();
    //Store all items categorized by section 
    Map<String, ArrayList<ItemPojo>> itemStore = new HashMap<String, ArrayList<ItemPojo>>(1);
    //Single item
    ItemPojo currentItem = null;
    //Current section name
    String sectionName = null;

    public AndroidSaxFeedParser() {
        super();
    }

    public Map<String, ArrayList<ItemPojo>> parse() { 

        RootElement root = new RootElement(SECTIONS);

        Element section = root.getChild(SECTION);
        Element itemHeader = section.getChild(ITEM_HEADER);

        //Read <name> tag as used as section
        itemHeader.setEndTextElementListener(new EndTextElementListener() {         
            public void end(String body) {
                sectionName = body.trim();
                Log.i("New Section", "New section found : " + sectionName);
            }
        });


        section.setStartElementListener(new StartElementListener() {            
            public void start(Attributes attributes) {
                //Clear the item list
                itemList = new ArrayList<ItemPojo>(0);
                Log.i("Size of list", "Size : " +itemList.size());
            }
        });
        section.setEndElementListener(new EndElementListener() {            
            public void end() {
                //Putting it into master list
                itemStore.put(sectionName, itemList);
            }
        });

        Element items = section.getChild(ITEMS);
        Element item = items.getChild(ITEM);

        items.setEndElementListener(new EndElementListener() {

            public void end() {
                //sort item with position 
                Collections.sort(itemList, ItemPojo.COMPARE_BY_POSITION);               
            }
        });     

        item.setStartElementListener(new StartElementListener() {

            public void start(Attributes attributes) {
                currentItem = new ItemPojo();
                currentItem.setItemPosition(Integer.parseInt(attributes.getValue("pos")));
                //Log.i("Test xml", "item initalised " + currentItem.toString());           
            }
        });

        item.setEndElementListener(new EndElementListener() {

            public void end() {

                itemList.add(currentItem);
                Log.i("Test xml", "New items found " + currentItem.toString());
            }
        });

        item.getChild(ITEM_NAME).setEndTextElementListener(new EndTextElementListener() {           
            public void end(String body) {
                currentItem.setItemName(body.trim());
            }
        });

        item.getChild(DESCRIPTION).setEndTextElementListener(new EndTextElementListener() {

            public void end(String body) {
                currentItem.setItemDescription(body.trim());
            }
        });

        try {
            Xml.parse(this.getInputStream(), Xml.Encoding.UTF_8, root.getContentHandler());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return itemStore;
    }
}