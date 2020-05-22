for(Iterator<Item> i = mItemList.iterator(); i.hasNext(); ) {
     Item item = i.next();
     if(item instanceof NoteItem && ((NoteItem) item).getIconSet() == iconSet) {
                                 //here ---------------------------^^
                                 //not sure what type returns getIconSet
                                 //but if it's not a primitive then you should use equals
         i.remove();
         foundCount++;
     }
}