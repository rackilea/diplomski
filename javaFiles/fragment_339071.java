public GGHSW13MasterSecretKeyParameters deserialize(InputStream in, Pairing pairing) throws IOException {
    DataInputStream dIn = new DataInputStream(in);

    int version = dIn.readInt();
    if (version != 1) {
        throw new RuntimeException("Unknown key format version: " + version);
    }

    int n = dIn.getInt();
    Element alpha = deserialize(dIn, pairing);

    return new GGHSW13MasterSecretKeyParameters(
            new GGHSW13Parameters(pairing, n),
            alpha
    );
}

public Element deserialize(DataInputStream dIn, Pairing pairing) throws IOException {
    if (dIn.readBoolean()) {
        return null;
    }

    int fieldIndex = dIn.readInt(); // TODO: check if this is in a sensible range
    int length = dIn.readInt(); // TODO: check if this is in a sensible range
    byte[] bytes = new byte[length];
    dIn.readFully(bytes); // throws an exception if there is a premature EOF
    Element e = pairing.getFieldAt(fieldIndex).newElementFromBytes(bytes);

    // this is a workaround because it.unisa.dia.gas.plaf.jpbc.field.curve.CurveElement does not serialize the infFlag
    boolean instOfCurveElementAndInf = dIn.readBoolean();
    if (instOfCurveElementAndInf) {
        //e.setToZero(); // according to the code this simply sets the infFlag to 1
        throw new IOException("The point is infinite. This shouldn't happen.");
    }
    return e;
}