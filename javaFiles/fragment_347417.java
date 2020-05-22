Globals globals = JsePlatform.standardGlobals();   
globals.set("image", CoerceJavaToLua.coerce(
        new BufferedImage(30,40,BufferedImage.TYPE_INT_RGB)));
LuaValue chunk = globals.load(
        "print(image:getWidth(), image:getHeight());");
chunk.call();