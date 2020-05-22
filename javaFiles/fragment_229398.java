class Element {
   String _id;
   List<Category> categories;
   public Element(){}
}

class Category {
   private List<Entry> entries;
   public Category (){}
}

class Entry {
   private List<String> units;
   public Entry (){}
}