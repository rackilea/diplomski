@Inject
AvailableCashClient availableCashClient;

@Inject
Validator validator;

@MockBean(AvailableCashClient)
public AvailableCashClient availableCashClient() {
    return Mockito.mock(AvailableCashClient);
}