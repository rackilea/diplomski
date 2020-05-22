outerMock.somefunction();  // throw so, this is the end

// ------- dead code blow:
// ** THIS SHOULD FAIL
verify(bMock).another();

// ** THIS SHOULD FAIL TOO
verify(cMock, never()).cleanup()