public class DecryptingPropertiesFactoryBean extends PropertiesFactoryBean {
  @Override
  protected Properties createProperties() throws IOException {
    final Properties encryptedProperties = super.createProperties();
    final Properties decryptedProperties = decrypt(encryptedProperties);
    return decryptedProperties;
  }
}