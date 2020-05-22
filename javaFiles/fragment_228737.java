void intro() {
    System.out.println(substate);
    switch (substate) {
    case 0:
        setSubState(2000, 1);
        break;
    case 1:

        setSubState(1000, 2);
        if (substate == 1) {
            background(calc(1000, 256));
        }

        break;
    case 2:

        setSubState(2000, 1);
        if (substate == 2) {
            background(256 - calc(2000, 256));
        }

        break;
    }

}

int calc(int max, int val) {
    int r;
    if ((millis() - counter) > max) {
        r = val;
    } else {
        r = (millis() - counter) * val / max;
    }
    System.out.println(r);
    return r;

}

void setState(int ms, int s) {
    if (millis() >= counter + ms) {
        state = s;
        counter = millis();
    }
}

void setSubState(int ms, int s) {
    if (millis() >= counter + ms) {
        substate = s;
        counter = millis();

    }

}