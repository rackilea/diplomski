@Resource
private SessionContext sessionContext;

private TestTransactionLocal local;

@PostConstruct
void init() {
    local = sessionContext.getBusinessObject(TestTransactionLocal.class);
}