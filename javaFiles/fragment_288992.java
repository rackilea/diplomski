public class UserWithPhone {
    Long id;
    String name;
    Long age;
    String number;
    PhoneType phoneType;

    UserWithPhone(){};
    UserWithPhone(User u, Phone p) {
        if (!u.id.equals(p.id))
            throw new IllegalArgumentException();
        this.id = u.id;
        this.name = u.name;
        this.age = u.age;
        this.number = p.number;
        this.phoneType = p.type;
    }

    UserWithPhone(User u) {
        this.id = u.id;
        this.name = u.name;
        this.age = u.age;
    }
    setPhoneDetails(Phone p) {
        if (!this.id.equals(p.id))
            throw new IllegalArgumentException();
        this.number = p.number;
        this.phoneType = p.type;
    }
}