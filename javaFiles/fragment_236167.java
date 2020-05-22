class Field {
    String field;
    List<Role> roles;

    Field(String field, List<Role> roles) {
        this.field = field;
        this.roles = roles;
    }
}

class Role {
    int id;
    int providedFor;

    Role(int id, int providedFor) {
        this.id = id;
        this.providedFor = providedFor;
    }
}