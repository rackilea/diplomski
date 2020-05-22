interface IonicalVector extends Vector {
    IonicalVector rotate(double phi);
}

class QuatrionsVector implements IonicalVector {
    @Override
    public IonicalVector rotate(double phi) { ... }
}