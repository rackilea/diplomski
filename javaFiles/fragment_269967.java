CustomerResponse customerResponseMock = mock(CustomerResponse.class);
ResponseEntity reMock = mock(ResponseEntity.class);

when(reMock.getBody()).thenReturn(customerResponseMock);
when(restTemplate.exchange(url, HttpMethod.GET, null, CustomerResponse.class)).thenReturn(reMock);

CustomerResponse cr = service.someMethod();