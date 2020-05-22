package de.scrum_master.app;

import java.util.Random;

public class Application {
  private final static Random RANDOM = new Random();

  public Response produceException() throws Exception {
    if (RANDOM.nextBoolean())
      throw new Exception("normal error");
    return new NormalResponse();
  }

  public Response produceSpecialException() throws Exception {
    if (RANDOM.nextBoolean())
      throw new Exception("special error");
    return new NormalResponse();
  }

  public static ErrorResponse defaultHandler(Exception e) {
    return new ErrorResponse("default handler", e);
  }

  public static void main(String[] args) {
    Application application = new Application();
    for (int i = 0; i < 5; i++) {
      try {
        System.out.println(application.produceException());
      } catch (Exception e) {
        System.out.println(defaultHandler(e));
      }
      try {
        System.out.println(application.produceSpecialException());
      } catch (Exception e) {
        System.out.println(defaultHandler(e));
      }
    }
  }

}