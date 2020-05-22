String boundaries = "(x > 750) & (x < 900)";
      ScriptEngineManager manager = new ScriptEngineManager();
      ScriptEngine engine = manager.getEngineByName("javascript");

      engine.eval("var x = 810;"); // Define x here
      engine.eval("var bln = false;")
      engine.eval("if (" + boundaries + ") bln = true; ")
      if((boolean)engine.eval(bln)) {
          // Do stuff
      }