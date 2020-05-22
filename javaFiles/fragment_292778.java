private void doIt(OrganizationServiceStub stub, OptionSetValue state, OptionSetValue status)
{
    OrganizationRequest request = new OrganizationRequest();
    request.setRequestName("SetState");

    ParameterCollection collection = new ParameterCollection();
    collection.addKeyValuePairOfstringanyType(pair("State", state));
    collection.addKeyValuePairOfstringanyType(pair("Status", status));
    request.setParameters(collection);

    Guid g = new Guid();
    g.setGuid("abc0def-ghi");
    EntityReference ref = new EntityReference();
    ref.setId(g);
    ref.setLogicalName("ei_teacherdetails");
    collection.addKeyValuePairOfstringanyType(pair("EntityMoniker", ref));

    Execute exe = new Execute();
    exe.setRequest(request);
    stub.execute(exe);
}