import java.io.FileReader;
import java.lang.reflect.Method;

import com.google.gson.Gson;

public class Foo
{
  public static void main(String[] args) throws Exception
  {
    Gson gson = new Gson();

    // input JSON:
    // {
    //   "dataClass":"com.stackoverflow.q6647866.MyObject",
    //   "method":"myMethod",
    //   "data":"{\"name\":\"fubar\"}"
    // }
    JSONRequest request = gson.fromJson(new FileReader("input.json"), JSONRequest.class);

    Class targetClass = Class.forName(request.dataClass);
    System.out.println("targetClass: " + targetClass);
    Object dataObject = gson.fromJson(request.data, targetClass);

    Method method = targetClass.getMethod(request.method);
    method.invoke(dataObject);
  }
}

class JSONRequest
{
  String method;
  String data;
  String dataClass;
}

class MyObject
{
  String name;
  public void myMethod()
  {
    System.out.println("running my method...");
  }
}