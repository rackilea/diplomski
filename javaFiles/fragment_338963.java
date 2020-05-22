public class Arguments
 {
  private String callFlow;

     public String getCallFlow ()
    {
       return callFlow;
    }

    public void setCallFlow (String callFlow)
     {
    this.callFlow = callFlow;
     }

    @Override
    public String toString()
    {
    return "ClassPojo [callFlow = "+callFlow+"]";
    }
}


 public class ApiData
 {
   private Arguments[] arguments;

    private String apiName;

   private String step;

  public Arguments[] getArguments ()
{
    return arguments;
}

public void setArguments (Arguments[] arguments)
{
    this.arguments = arguments;
}

public String getApiName ()
{
    return apiName;
}

public void setApiName (String apiName)
{
    this.apiName = apiName;
}

public String getStep ()
{
    return step;
}

public void setStep (String step)
{
    this.step = step;
}

@Override
public String toString()
{
    return "ClassPojo [arguments = "+arguments+", apiName = "+apiName+", step = "+step+"]";
}
}

 public class Jobj
{
private ApiData[] apiData;

public ApiData[] getApiData ()
{
    return apiData;
}

public void setApiData (ApiData[] apiData)
{
    this.apiData = apiData;
}

@Override
public String toString()
{
    return "ClassPojo [apiData = "+apiData+"]";
}
}