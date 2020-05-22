@RunWith(PowerMockRunner.class)
@PrepareForTest({DataSourceTransactionManager.class})
public class JobPollerTest {
.....................
 private DataSourceTransactionManager mDataSourceTransactionManager;
......................

    mDataSourceTransactionManager = PowerMockito.mock(DataSourceTransactionManager.class);

     DefaultTransactionDefinition def = new DefaultTransactionDefinition();
            def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);

            Mockito.when(mDataSourceTransactionManager.getTransaction(def)).thenReturn(null);