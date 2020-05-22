private final SimpleStringProperty name;
...
public String getName(){
    return name.get();
}

public void setName(String nName){
    name.set(nName);
}

public StringProperty nameProperty(){
    return name;
}