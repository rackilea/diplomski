static Operators getOperatorForChar(char op) {
    for(Operators val: values())
        if(op == val.operator)
            return val; //return enum type

    return null;
}