for(byte bytecode : codeToExecute) {
    if (bytecode == XX) {
        // ...do stuff...
    } else if (bytecode == XY) {
        int a = pop();
        int b = pop();
        push(a+b);
    } else if (bytecode == XZ) {
        // ...do stuff...
    } // ... and so on for each possible instruction ...
}