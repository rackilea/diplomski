// create your rowHandler
public class Db2RowHandler implements MySpecialRowHandler {
    void handleRow(Object row) throws DataException, FileException, WhateverException {
        // what you would have done in ibatis RowHandler, with your own exceptions
    }
}
// use it.
MySpecialTemplate template = new MySpecialTemplate(daoManager);
try {
    template.queryWithRowHandler("selectAllDb2", new Db2RowHandler());
} catch (DataException e) {
    // ...
} catch (FileException e) {
    ...