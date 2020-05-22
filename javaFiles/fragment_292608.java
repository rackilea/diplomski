Category[] mapping = {
    Category.A, // Opcode 0
    Category.A, // Opcode 1
    Category.B, // Opcode 2
    ...
};

int opcode = ...
Category category = mapping[opcode];