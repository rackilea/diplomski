public interface BuildableCodeData {

  public void setCode(String code);

  public void setDisplayName(String name);
}

public class Builder<T extends BuildableCodeData> {
  private T codeData;

  public Builder(T codeData) {
    this.codeData = codeData;
  }

  public Builder<T> setCode(String code) {
    codeData.setCode(code);
    return this;
  }

  public Builder<T> setDisplayName(String displayName) {
    codeData.setDisplayName(displayName);
    return this;
  }

  public T build() {
    return codeData;
  }
}