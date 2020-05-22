Counter c = new Counter() {   
    public int count() {
        super.count();   
        return super.count();   
    } 
}

c.count(); // now count 2