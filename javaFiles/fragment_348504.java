public E encode(F obj) {
    return codec2.encode(Codec.this.encode(obj));
}

public F decode(E obj) {
    return Codec.this.decode(codec2.decode(obj));
}