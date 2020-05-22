...
public class CommitTest {

    @Autowired
    TestRepo repo;

    @Autowired
    TransactionTemplate txTemplate;

    @Test
    public void testCommit() {
        txTemplate.execute(new TransactionCallbackWithoutResult() {

          @Override
          protected void doInTransactionWithoutResult(TransactionStatus status) {
            repo.createPerson();
            // ...
          }
        });

        // ...
        System.out.println("Something after the commit...");
    }