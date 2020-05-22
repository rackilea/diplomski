package logic;
public class Logic {
boolean AND(boolean A, boolean B) {
    if (A == true && B == true) {
        return true;
    }
    return false;
}

boolean OR(boolean A, boolean B) {
    if (A == false && B == false) {
        return false;
    }
    return true;
}

boolean NOT(boolean A) {
    if (A == true) {
        return false;
    }
    return true;
}

boolean NAND(boolean A, boolean B) {
    if (A == true && B == true) {
        return false;
    }
    return true;
}

boolean NOR(boolean A, boolean B) {
    if (A == false && B == false) {
        return true;
    }
    return false;
}

boolean XOR(boolean A, boolean B) {
    if (A == B) {
        return false;
    }
    return true;
}

boolean XNOR(boolean A, boolean B) {
    if (A == B) {
        return true;
    }
    return false;
}