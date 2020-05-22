TERADATA(()-> DbManager.getTeradataConnection()),
SQLITE(arg -> DbManager.getSQLiteConnection(arg)),
FOO(()-> DbManager.getFooConnection(),
    arg->DbManager.getFooConnection(arg));
//Foo supports both styles: with and without a parameter

private final Supplier<DatabaseConnection> supplier;
private final Function<String, DatabaseConnection> function;

private DbConnectionSupplier(Supplier<DatabaseConnection> supplier) { 
    this.supplier = supplier;
    this.function = null;
}    

private DbConnectionSupplier(Function<String, DatabaseConnection> function) { 
    this.function = function;
    this.supplier = null;
}    `

private DbConnectionSupplier(
    Supplier<DatabaseConnection> supplier,
    Function<String, DatabaseConnection> function) { 
    this.function = function;
    this.supplier = supplier;
}    

public DatabaseConnection getConnection(String arg) {
   if (function==null) throw ...
   return function.apply(arg);
}

public DatabaseConnection getConnection() {
   if (supplier==null) throw ...
   return supplier.get();
}