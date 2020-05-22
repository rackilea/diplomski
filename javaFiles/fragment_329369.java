InstructionModel(String example, int sameExample, // Other params
                        ) {

    Instruction foo = Instruction.fromNumber(0x014b4820);
    Instruction bar = Instruction.fromString("add $t1, $t2, $t3");
    assert(foo.equals(bar));

    // Some other stuff
}