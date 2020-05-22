public class MessageSenderModule extends AbstractModule {
  @Override 
  protected void configure() {
    bind(MessageSender.class).to(EmailBasedMessageSender.class);
    FactoryModuleBuilder factoryModuleBuilder = new FactoryModuleBuilder();
    install(factoryModuleBuilder.build(MessageFactory.class));
  }
}