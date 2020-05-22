class Object[] extends Object implements Cloneable, Serializable {
    public final int length = /*value from array creation*/;
    public Object[] clone() {
        try {
            return (Object[]) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e.getMessage());
        }
    }
}

class User[] extends Object[] {
    public User[] clone() {
        return (User[]) super.clone();
    }
}