public void serialize(GGHSW13MasterSecretKeyParameters msk, OutputStream out) throws IOException {
    DataOutputStream dOut = new DataOutputStream(out);

    dOut.writeInt(1); // version of the serialized format
    dOut.writeInt(msk.getParameters().getN());

    serialize(msk.getAlpha(), dOut, msk.getParameters().getPairing());
}

public void serialize(Element elem, DataOutputStream dOut, Pairing pairing) throws IOException {
    dOut.writeBoolean(elem == null);
    if (elem == null) {
        return;
    }

    dOut.writeInt(pairing.getFieldIndex(elem.getField()));
    byte[] bytes = elem.toBytes();
    dOut.writeInt(bytes.length);
    dOut.write(bytes);

    // this is a workaround because it.unisa.dia.gas.plaf.jpbc.field.curve.CurveElement does not serialize the infFlag
    dOut.writeBoolean(elem instanceof CurveElement && elem.isZero());
    if (elem instanceof CurveElement && elem.isZero()) {
        throw new IOException("Infinite element detected. They should not happen.");
    }
}