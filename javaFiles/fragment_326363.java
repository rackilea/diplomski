public interface Player<T extends Player<T>> {
    void setPartner(T partner);
}

public class Human implements Player<Human> {
    private Human partner;

    public void setPartner(Human partner) {
        this.partner = partner;
    }
}