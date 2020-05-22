private String getRequest()
{
    // Make Call
    return jsonString;
}

public TypeA getA()
{
    return new Gson().fromJson(getRequest(), TypeA.class);
}

public TypeB getB()
{
    return new Gson().fromJson(getRequest(), TypeB.class);
}

public TypeC getC()
{
    return new Gson().fromJson(getRequest(), TypeC.class);
}