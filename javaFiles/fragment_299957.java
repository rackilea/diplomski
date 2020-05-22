public void print() {
    System.out.println(this.toString());
}

@Override
public String toString() {
    StringBuilder display = new StringBuilder();
    for(Integer current: this) {
        display.append(current).append(',');
    }
    return display.toString().substring(0, display.length()-1);
}