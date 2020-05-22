public abstract class EventExecutor {
public static class OnBalanceChangeExecutor extends EventExecutor {

        private BalanceDao balanceDao;

        @Override
        public void executeEvent() {
            BigDecimal balance;
            //getting the balance
            balanceDao.add(balance);
        }

        //GET, SET, others
    }}