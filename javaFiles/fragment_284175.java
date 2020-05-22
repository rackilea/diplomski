@Test
public void testFoo()
    {
    // setup
    Authentication mockAuthentication = createMock(Authentication.class);
    Collection authorities = Collections.emptyList();
    expect(mockAuthentication.getAuthorities()).andReturn(authorities);

    // exercise
    EasyMock.replay(mockAuthentication);
    Collection<? extends GrantedAuthority> retAuth = mockAuthentication.getAuthorities();

    // verify
    EasyMock.verify(mockAuthentication);
    assertEquals(authorities, retAuth);
    }