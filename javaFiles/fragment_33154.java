String customerId =...
List<Order> myOrders = ...

Connection mockConnection = EasyMock.createMock(Connection.class);

EasyMock.expect(mockConnection.fetchOrders(customerId)).andReturn(myOrders);
EasyMock.replay(mockConnection);

//call system under test:
List<Orders> results = getOrders(mockConnection, customerId);

List<Orders> expectedResults = ....

assertEquals(expectedResults, results);