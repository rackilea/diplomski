public enum SwitchCases {
    Case1, Case2, etc;
}

void runAllCases() {
    for (SwitchCases sc : SwitchCases.values()) {
        switchMethod(sc);
    }
}

int switchMethod(SwitchCases sc) {
    switch (sc) {
        case Case1: return x;
        case Case2: return y;
        // etc...
    }
}