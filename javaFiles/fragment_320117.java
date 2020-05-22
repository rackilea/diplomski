ChefService chefServiceMock = mock(ChefService.class);
// some reasonable, expected entry value
List<CookbookVersion> cookbookVersions = ...; 
when(chefServiceMock.listCookbookVersions()).thenReturn(cookbookVersions);
// You're not actually using the API object, so you can pass in null.
// It'd be wiser to remove it altogether.
String actual = testObject.getAllCookBooks(chefServiceMock, null);