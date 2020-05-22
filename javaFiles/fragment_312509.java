while (true) {
    switch(instructions[pc]) {
    case LDC:
        sp += 1; // make space for constant
        stack[sp] = constants[instructions[pc+1]];
        pc += 2; // two-byte instruction
    case IADD:
        stack[sp-1] += stack[sp]; // add to first operand
        sp -= 1; // pop other operand
        pc += 1; // one-byte instruction
    case ISTORE_0:
        locals[0] = stack[sp];
        sp -= 1; // pop
        pc += 1; // one-byte instruction
    // ... other cases ...
    }
}