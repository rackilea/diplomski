class City {
    private String name,pincode;

    public City(String name, String pincode) {
        this.name = name;
        this.pincode = pincode;
    }

    public String getPincode(){
        return pincode;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof  String){
            return obj.equals(name);
        }else if(obj instanceof City){
            return name.equals(((City) obj).name);
        }else{
            return false;
        }
    }
}