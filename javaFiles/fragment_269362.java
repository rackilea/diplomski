package de.scrum_master.app;

public class Application implements TextTransformer {
  @Override
  public String transform(String text) {
    String geekSpelling;
    try {
      geekSpelling = toGeekSpelling(text);
      return toUpperCase(geekSpelling);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

  }

  private String toGeekSpelling(String text) throws InterruptedException {
    Thread.sleep(100);
    return replaceVovels(text).replaceAll("[lL]", "1");
  }

  private String replaceVovels(String text) throws InterruptedException {
    Thread.sleep(75);
    return text.replaceAll("[oO]", "0").replaceAll("[eE]", "Ɛ");
  }

  private String toUpperCase(String text) throws InterruptedException {
    Thread.sleep(50);
    return text.toUpperCase();
  }

  public static void main(String[] args) throws InterruptedException {
    System.out.println(new Application().transform("Hello world!"));
  }
}