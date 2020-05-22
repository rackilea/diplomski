public A(A other) {
    if(other.a != null) {
        this.a = new A(other.a);
    }
    if(other.hArray != null) {
        this.hArray = new E[other.hArray.length];
        for(int index = 0; index < other.hArray.length; index++) {
            this.hArray[index] = other.hArray[index].clone();
        }
    }
}