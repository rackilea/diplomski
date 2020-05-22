public class Word extends BaseObservable {
private String contents;

public Word() {
    contents = "";
}

public Word(String contents) {
    this.contents = contents;
}

@Bindable
public String getContents() {
    return contents;
}

public void setContents(String contents) {
    this.contents = contents;
    notifyPropertyChanged(BR.contents);
  }
}