public class LlamaGame implements ApplicationListener {
  List<Llama> llamas = new ArrayList<>();

  // ...

  @Override
  public void render() {
    // ...
    for (Llama llama : llamas) {
      llama.move()
    }
    // ...
  }
}