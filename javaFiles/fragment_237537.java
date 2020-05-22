private static Instruction getInstruction(int address) {
    Iterator<Instruction> iterator = instrHolder.iterator();
    while (iterator.hasNext()) {
        Instruction current = iterator.next();
        if (current.getSomeProperty().equals(someValue))
            return current;
    }
    return null;
}