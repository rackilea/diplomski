foo:
while(cond1) {
    code;
    while(cond2) {
        if(cond3) {
            continue foo;
        }
    }
}