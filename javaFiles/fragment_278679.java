Map<Class<? extends Entity>,List<Entity>> centralModelRelated = new HashMap<Class<? extends Entity>, List<Entity>>();
Capture<ApplyInitialDumpOnCentralModel> captureObject = new Capture<ApplyInitialDumpOnCentralModel>();

executionUnit = EasyMock.createMock(ExecutionUnit.class);
EasyMock.expect(executionUnit.executeSynch(EasyMock.capture(captureObject))).andReturn(new Object()).once();;
EasyMock.replay(executionUnit);

centralModel.applyInitialDump(centralModelRelated);

EasyMock.verify(executionUnit); //Don't forget to verify your mocks :)

CentralModelUnitOfWork expectedUnitOfWork = new ApplyInitialDumpOnCentralModel(omContext, centralModelRelated);
ApplyInitialDumpOnCentralModel actualUnitOfWork = captureObject.getValue();
//Then whatever assertion you want to make about the expected and actual unit of work.