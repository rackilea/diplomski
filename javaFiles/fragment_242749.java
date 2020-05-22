private List<DataSlice> slices;
public class DataSlice {
  private ArrayList<Object> data;
  private File backingFile;

  private void load() {
    data = deserialize(backingFile);
  }

  private void release() {
    if(dirty) save(data, backingFile);
    data = null; // data is garbage collected, but there is a risk the objects are still referenced in memory
  }

  private void doCrudOperation() {
    dirty = true;
    doSomething();
  }
}