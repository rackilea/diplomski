class Static { static void m() {} }
Static s = new Static();

s.m(); //compiles
someStream.forEach(s::m); //does not compile
someStream.forEach(Static::m); //that's ok