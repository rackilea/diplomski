public class DatabaseDataProvider {

 private final Supplier<Map<String, String>> dbDataSupplier;

 public DatabaseDataProvider(long duration) {
  final Supplier<Map<String, String>> supplier = () -> loadDbData();

  if (duration <= 0) {
   this.dbDataSupplier = supplier; //no caching
  } else {
   this.dbDataSupplier =
    Suppliers.memoizeWithExpiration(supplier, duration, TimeUnit.SECONDS);
  }

 }

 public Map<String, String> getAllDbData() {
  return dbDataSupplier.get();
 }

 private Map<String, String> loadDbData() {
  //DB magick
 }