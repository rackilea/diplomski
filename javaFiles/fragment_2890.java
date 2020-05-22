public static void main(String [] args) throws Exception {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName ("rhino"); 
        data data = new data();
        Context.enter().getWrapFactory().setJavaPrimitiveWrap(false);

        try 
        { 
                engine.eval("function test(data) { return data.get('value1') + 5;};"); 
                System.out.println("Result:" + ((Invocable)engine).invokeFunction("test", data)); 
        } 
        catch (Exception e) 
        { 
                e.printStackTrace(); 
        } 
    }

    public static class data 
    { 
       Double value = 1.0d; 
       public Number get(String arg)  {  return value; } 
    }