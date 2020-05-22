@Override
public String toString(){
    String toDisplay = this.name + " " + this.code;
    if(department != null) toDisplay += "\n" + department.toString();
    return toDisplay;
}