CompiledScript script = ((Compilable) scriptEngine).compile(reader);
Bindings sb = new SimpleBindings();
script.eval(sb); // Put the Lua functions into the sb environment
LuaValue luaDog = CoerceJavaToLua.coerce(dog); // Java to Lua
LuaFunction onTalk = (LuaFunction) sb.get("onTalk"); // Get Lua function
LuaValue b = onTalk.call(luaDog); // Call the function
System.out.println("onTalk answered: " + b);
LuaFunction onWalk = (LuaFunction) sb.get("onWalk");
LuaValue[] dogs = { luaDog };
Varargs dist = onWalk.invoke(LuaValue.varargsOf(dogs)); // Alternative
System.out.println("onWalk returned: " + dist);