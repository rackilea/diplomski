private class HairSalon implements Comparable<HairSalon>{
    public String type = null;
    public double price = 0;
    public float number = 0;

    public HairSalon(String type,double price,float number){
        this.type = type;
        this.price = price;
        this.number = number;
    }

    @Override
    public int compareTo(HairSalon compa) {
        int ret = 0;
        if(this.price < compa.price) ret = -1;

        if(this.price > compa.price){
            ret = 1;
        }else{ret = 0;}

        return ret;
    }