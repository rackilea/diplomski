public class StartChallengeJob extends DemoJob {

  public DemoJob (ISharedObject so, MysqlDb mysqldb) {
    super(so, mysqldb);
  }

  public DemoJob (ISharedObject so) {
    super(so);
  }

  public StartChallengeJob() {
    super();
  }

  public void execute(ISchedulingService service) {    
    log.error("test");   
  }    
}