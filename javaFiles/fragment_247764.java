@Mock 
private Socket mockedSocket;
@Mock 
private SocketProvider mockedProvider;

// ...
conncectionBroker.setSocketProvider(mockedProvider);

// ...

when(mockedProvider.getSocket()).return(mockedSocket); // or a stub / spy / testSocket...