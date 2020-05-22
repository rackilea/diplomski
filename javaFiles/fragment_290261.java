private int writeAttribute(final String attributeName) {
    dout.putShort(utfConstant(attributeName));
    dout.putInt(0);
    return dout.position();
}

private void endAttribute(final int attributeStart) {
    dout.putInt(attributeStart- 4, dout.position() - attributeStart);
}

private void writeCode() {
    final int codeAttributeStart = writeAttribute("Code");

    dout.writeShort(1);//max stack
    dout.writeShort(0);//max locals
    dout.writeInt(2);//code length
    dout.writeByte(0x05);//iconst_2 opcode
    dout.writeByte(0xAC);//ireturn opcode
    dout.writeShort(0);//exception count
    dout.writeShort(0);//attribute count

    endAttribute(codeAttributeStart);
}