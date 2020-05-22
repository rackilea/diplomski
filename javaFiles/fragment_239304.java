// Initialize objects
    di.setEdgeId("edgeId");
    di.setIdentityEndpoint("identityEndpoint");
    di.setUsername("username");

    di1.setEdgeId("edgeId");
    di1.setIdentityEndpoint("identityEndpoint");
    di1.setUsername("username");

    // Change value of var and test equal
    di1.setEdgeId("edgeIdm");
    assertFalse(di.equals(di1));
    di1.setEdgeId("edgeId");

    // same
    di1.setIdentityEndpoint("identityEndpointm");
    assertFalse(di.equals(di1));
    di1.setIdentityEndpoint("identityEndpoint");

    // Same
    di1.setUsername("usernamem");
    assertFalse(di.equals(di1));
    di1.setUsername("username");

    // Then at the end perform the other tests
    assertTrue(di.equals(di));
    assertTrue(di.equals(di1));
    assertFalse(di.equals(null));
    assertFalse(di.equals(42));