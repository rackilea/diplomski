@Override
public void init(String flag) {
    if (flag == null)
        throw IllegalArgumentException("Flag cannot be null");
    this.dependentVariable = flag;
    caller();
}