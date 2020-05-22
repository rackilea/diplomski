public class DateCodec extends TypeCodec<Date> {

    private final TypeCodec<LocalDate> innerCodec;

    public DateCodec(TypeCodec<LocalDate> codec, Class<Date> javaClass) {
        super(codec.getCqlType(), javaClass);
        innerCodec = codec;
    }

    @Override
    public ByteBuffer serialize(Date value, ProtocolVersion protocolVersion) throws InvalidTypeException {
        return innerCodec.serialize(LocalDate.fromMillisSinceEpoch(value.getTime()), protocolVersion);
    }

    @Override
    public Date deserialize(ByteBuffer bytes, ProtocolVersion protocolVersion) throws InvalidTypeException {
        return new Date(innerCodec.deserialize(bytes, protocolVersion).getMillisSinceEpoch());
    }

    @Override
    public Date parse(String value) throws InvalidTypeException {
        return new Date(innerCodec.parse(value).getMillisSinceEpoch());
    }

    @Override
    public String format(Date value) throws InvalidTypeException {
        return value.toString();
    }

}