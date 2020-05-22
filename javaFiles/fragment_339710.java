public class CommunicationChannelFactoryImpl implements BeanFactoryAware {
  FactoryBean factoryBean;

  public void setBeanFactory(FactoryBean factoryBean) {
    this.factoryBean = factoryBean;
  }
  public CommunicationChannel getCommunicationChannel(String channel, Map<String, String> channelProperties) {

    if(channel.equals("ONE")   {
      return this.factoryBean.getBean("oneChannel");
    }

    if(channel.equals("TWO") {
      return this.factoryBean.getBean("secondChannel");
    }
  }
}