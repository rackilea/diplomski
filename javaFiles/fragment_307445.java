public class MySpecialTemplate extends SqlMapDaoTemplate {
    ...
    public void queryWithRowHandler(String id, 
        final MySpecialRowHandler myRowHandler
    ) throws DataException, FileException, WhateverException {
        // "holder" will hold the exception thrown by your special rowHandler
        // both "holder" and "myRowHandler" need to be declared as "final"
        final Set<Exception> holder = new HashSet<Exception>();
        this.queryWithRowHandler(id,new RowHandler() {
            public void handleRow(Object row) {
                try {
                    // your own row handler is executed in IBatis row handler
                    myRowHandler.handleRow(row);
                } catch (Exception e) {
                    holder.add(e);
                }
            }
        });
        // if an exception was thrown, rethrow it.
        if (!holder.isEmpty()) {
            Exception e = holder.iterator().next();
            if (e instanceof DataException)     throw (DataException)e;
            if (e instanceof FileException)     throw (FileException)e;
            if (e instanceof WhateverException) throw (WhateverException)e;
            // You'll need this, in case none of the above works
            throw (RuntimeException)e;
        }
    }
}