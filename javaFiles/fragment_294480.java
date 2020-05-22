@Override
    public AbstractTicketingClientDTO doSomethingRemotely(final Client client) throws RemoteException {
        return (MyDTO) HibernateCommandExecuter.executeCommand(new HibernateCommand<MyDTO>() {
            public AbstractTicketingClientDTO execute(Object...args) throws Exception{
                MyDTO dto = someService.someBusinessmethod(client);
                return dto;
            }
        },false);
    }