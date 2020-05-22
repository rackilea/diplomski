public class AWSclient {

  @Inject
  public AWSclient(ReadApiConfiguration conf) {
     initConnection(conf.getDynamoDBConfig().getSecretKey(), ...)
  }

}