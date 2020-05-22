public class RubyIndexCreator extends IndexCreator {
  private IndexCreator rubyCreator;
  public RubyIndexCreator() {
    ScriptEngineManager factory = new ScriptEngineManager();
    ScriptEngine engine = factory.getEngineByName("ruby");
    FileReader r = new FileReader("ruby_index_creator.rb");
    try {
      rubyCreator = engine.eval(r);
    }
    finally {
      r.close();
    }
  }

  public Object create(String someArg) {
    return rubyCreator.create(someArg);
  }
}