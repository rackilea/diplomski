@Singleton
public class EnumCodec implements Codec<CampaignEmailStatus> {

  @Override
  public CampaignEmailStatus decode(BsonReader reader, DecoderContext decoderContext) {
    String enumString = reader.readString();
    return CampaignEmailStatus.valueOf(enumString);
  }

  @Override
  public void encode(BsonWriter writer, CampaignEmailStatus value, EncoderContext encoderContext) {
    String enumString = value.name();
    writer.writeString(enumString);
  }

  @Override
  public Class<CampaignEmailStatus> getEncoderClass() {
    return CampaignEmailStatus.class;
  }
}