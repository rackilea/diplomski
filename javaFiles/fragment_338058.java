//My generic CRUD Operations
public abstract class AbstractCRUDControllerBean<E, PK extends Serializable> implements AbstractCRUDController<E, PK> {

  public ResponseEntity<E[]> fetchAll() { ... }

  public ResponseEntity<E> fetch(@PathVariable("id") PK id) { ... }

  public ResponseEntity<E> add(@RequestBody E entity) { ... }

  public ResponseEntity<E> update(@PathVariable("id") PK id, @RequestBody E entity) { ... }

  public ResponseEntity<E> remove(@PathVariable("id") PK id) { .. }
}