@Mock
VehiclesApi vehiclesApiMock;
// ...

// when the api method is invoked with the expected dataSetId and vehicleId
Mockito.when(vehiclesApiMock.vehiclesGetVehicleAsync(Mockito.eq(datasetId), Mockito.eq(vehicleId),
                                                 Mockito.any(ApiCallback.class)))
       // I want to invoke the callback with the mocked data
       .then(invocationOnMock -> {
           ApiCallback<VehicleResponse> callback = invocationOnMock.getArgument(2);
           callback.onSuccess(mockedVehicleResponse, mockedStatusCode,
                              mockedResponseHeaders);
           return null; // it is a void method. So no value to return in T then(...).
       });