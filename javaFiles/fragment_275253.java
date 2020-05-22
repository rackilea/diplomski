public class ScriptC_mono extends ScriptC {
  //...

  public void forEach_root(Allocation ain, Allocation aout) {
    // check ain
    if (!ain.getType().getElement().isCompatible(__U8_4)) {
        throw new RSRuntimeException("Type mismatch with U8_4!");
    }
    // check aout
    if (!aout.getType().getElement().isCompatible(__U8_4)) {
        throw new RSRuntimeException("Type mismatch with U8_4!");
            // Verify dimensions
    Type tIn = ain.getType();
    Type tOut = aout.getType();
    if ((tIn.getCount() != tOut.getCount()) ||
        (tIn.getX() != tOut.getX()) ||
        (tIn.getY() != tOut.getY()) ||
        (tIn.getZ() != tOut.getZ()) ||
        (tIn.hasFaces() != tOut.hasFaces()) ||
        (tIn.hasMipmaps() != tOut.hasMipmaps())) {
        throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
    }
    forEach(mExportForEachIdx_root, ain, aout, null);
  }
}