class Daddy {
    public foo(){...}
    public createBaby(){
        Baby baby = new Baby(this);
        // baby now has a reference to Daddy
    }
}


class Baby {
    Daddy daddy;
    public Baby(Daddy daddy){
        this.daddy = daddy;
    }
    ...
    public callDaddy(){
        daddy.foo();
    }
}