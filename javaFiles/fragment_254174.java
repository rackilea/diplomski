Gson gson = new Gson();
RootObject rootObject = new RootObject();

rootObject = gson.fromJson("Your json string or content", RootObject.class)

public class InputParameters
{
  private String a;

  public String getA() { return this.a; }

  public void setA(String a) { this.a = a; }

  private String b;

  public String getB() { return this.b; }

  public void setB(String b) { this.b = b; }

  private String c;

  public String getC() { return this.c; }

  public void setC(String c) { this.c = c; }

  private String d;

  public String getD() { return this.d; }

  public void setD(String d) { this.d = d; }

  private String e;

  public String getE() { return this.e; }

  public void setE(String e) { this.e = e; }

  private String f;

  public String getF() { return this.f; }

  public void setF(String f) { this.f = f; }

  private String g;

  public String getG() { return this.g; }

  public void setG(String g) { this.g = g; }
}

public class OutputParameters
{
  private String dId;

  public String getDId() { return this.dId; }

  public void setDId(String dId) { this.dId = dId; }

  private String fd;

  public String getFd() { return this.fd; }

  public void setFd(String fd) { this.fd = fd; }
}

public class RootObject
{
  private int tId;

  public int getTId() { return this.tId; }

  public void setTId(int tId) { this.tId = tId; }

  private String name;

  public String getName() { return this.name; }

  public void setName(String name) { this.name = name; }

  private InputParameters inputParameters;

  public InputParameters getInputParameters() { return this.inputParameters; }

  public void setInputParameters(InputParameters inputParameters) { this.inputParameters = inputParameters; }

  private OutputParameters outputParameters;

  public OutputParameters getOutputParameters() { return this.outputParameters; }

  public void setOutputParameters(OutputParameters outputParameters) { this.outputParameters = outputParameters; }
}