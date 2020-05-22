class B extends A {
    @JsonIgnore
    transient String temp_1;
    @JsonIgnore
    transient String temp_2;
    //Getter and setters
    public String getTemp_1() {return temp_1;}
    public void setTemp_1(String temp_1) {this.temp_1 = temp_1;}
    public String getTemp_2() {return temp_2;}
    public void setTemp_2(String temp_2) {this.temp_2 = temp_2;}
}