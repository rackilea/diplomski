class IndexedColumn extends Column<List<String>, String>
   private final int index;
   public IndexedColumn(int index) {
     super(new EditTextCell();
     this.index = index;
   }

   @Override
   public String getValue(List<String> object) {
      return object.get(this.index);
   }
}