Category[] mapping = {
    Category.A, // Opcode 13 (the first possible opcode)
    Category.A, // Opcode 42 (the second possible opcode)
    Category.B, // Opcode 88 (the third possible opcode)
    ...
};

int opcode = opcodeEnum.ordinal();
Category category = mapping[opcode];