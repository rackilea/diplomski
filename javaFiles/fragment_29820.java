1. expect(session.getAttribute("testAttribute")).andReturn("testValue").times(2);

2. expect(session.getAttribute("testAttribute")).andReturn("testValue").anyTimes();

3. expect(session.getAttribute("testAttribute")).andReturn("testValue");
   expect(session.getAttribute("testAttribute")).andReturn("testValue");