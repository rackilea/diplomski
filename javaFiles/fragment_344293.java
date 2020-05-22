if (engine instanceof Compilable) {
        try {
            ((Compilable) engine).compile("");
        } catch (Error e) {
            System.out.println(engineName + " Script compilation is not supported.");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        System.out.println(engineName + " Script compilation is supported.");
    } else {
        System.out.println(engineName + " Script compilation is not supported.");
    }