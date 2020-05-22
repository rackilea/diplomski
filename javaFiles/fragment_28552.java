public static void copyAnItem(Document fromDoc, Document toDoc, String itemName){
    try {
        if(fromDoc.hasItem(itemName)) {
            toDoc.copyItem(fromDoc.getFirstItem(itemName));
        }
    } catch (NotesException e) {
        // your exception handling
    }
}