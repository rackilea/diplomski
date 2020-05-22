// SnuggleEngine engine = new SnuggleEngine();
mid = env->GetMethodID(engine, "<init>", "()V");
jobject snuggle = env->NewObject(engine, mid);

// SnuggleSession session = engine.createSession();
mid = env->GetMethodID(engine, "createSession", "()L"SNUGGLE_SESSION";");
jobject session = env->CallObjectMethod(snuggle, mid);

// SnuggleInput input = new SnuggleInput("$$ x+2=3 $$");
mid = env->GetMethodID(Cinput , "<init>", "(Ljava/lang/String;)V");
jobject input_elem = env->NewObject(Cinput, mid, latex);

// session.parseInput(input);
mid = env->GetMethodID(Csession , "parseInput", "(L"SNUGGLE_INPUT";)Z");
env->CallBooleanMethod(session, mid, input_elem);

// String xmlString = session.buildXMLString();
mid = env->GetMethodID(Csession , "buildXMLString", "()Ljava/lang/String;");
result = (jstring) env->CallObjectMethod(session, mid);