private LinkedList<String> getWorkbookReferences(HSSFWorkbook wb) {
    LinkedList<String> references = new LinkedList<>();

    try {
        // 1. Get InternalWorkbook
        Field internalWorkbookField = HSSFWorkbook.class.getDeclaredField("workbook");
        internalWorkbookField.setAccessible(true);
        InternalWorkbook internalWorkbook = (InternalWorkbook) internalWorkbookField.get(wb);

        // 2. Get LinkTable (hidden class)
        Method getLinkTableMethod;
        getLinkTableMethod = InternalWorkbook.class.getDeclaredMethod("getOrCreateLinkTable", null);

        getLinkTableMethod.setAccessible(true);
        Object linkTable = getLinkTableMethod.invoke(internalWorkbook, null);

        // 3. Get external books method
        Method externalBooksMethod = linkTable.getClass().getDeclaredMethod("getExternalBookAndSheetName", int.class);
        externalBooksMethod.setAccessible(true);

        // 4. Loop over all possible workbooks
        int i = 0;
        String[] names;
        try {
            while( true) {
                names = (String[]) externalBooksMethod.invoke(linkTable, i++) ;                     if (names != null ) {
                    references.add(names[0]);
                }
            }
        }
        catch  ( java.lang.reflect.InvocationTargetException e) {
            if ( !(e.getCause() instanceof java.lang.IndexOutOfBoundsException) ) {
                throw e;
            }
        }
    } catch (NoSuchFieldException | NoSuchMethodException | SecurityException | InvocationTargetException | IllegalAccessException e) {
        e.printStackTrace();
    }

    return references;
}