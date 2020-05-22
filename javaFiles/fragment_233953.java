abstract class TheClass<T extends Model> {
  protected abstract List<T> getDataList();
}

class ProgramClass extends TheClass<Program> {
  protected List<Program> getDataList() { return programs; }
}