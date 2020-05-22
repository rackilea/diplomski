@Override
public void visitCode()
{
    before();
}

@Override
public void visitInsn(int opcode)
{
    if (OpcodesUtil.isXRETURN(opcode))
    {
        after();
    }

    super.visitInsn(opcode);
}