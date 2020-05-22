@Override
public int compare(Object o1, Object o2) {
    Integer register1 = null;
    Integer register2 = null;

    if(o1 instanceof User) {
        register1 = ((User)o1).getRegister();
    } else if(o1 instanceof Staff) {
        register1 = ((Staff)o1).getRegister();
    }

    if(o2 instanceof User) {
        register2 = ((User)o2).getRegister();
    } else if(o1 instanceof Staff) {
        register2 = ((Staff)o2).getRegister();
    }

    if(register1 != null && register2 != null) {
        return register1.compareTo(register2);
    }
    return 0;
}