jfieldID procSolStepsID = env->GetFieldID(clsPS, "processSolutionSteps", "[Ljava/lang/String;");
jclass clsStr = env->FindClass("java/lang/String");
for (i = 0; i < listCount; ++i) {
    jobject procSolObj = env->NewObject(clsPS, env->GetMethodID(clsPS, "<init>", "()V"));
    jobjectArray solSteps = env->NewObjectArray(steps, clsStr, NULL);
    for (j = 0; j < steps; ++j) {
        // prepare step_name
        env->SetObjectArrayElement(solSteps, j, env->NewStringUTF(step_name));
    }
    env->SetObjectField(procSolObj, procSolStepsID, solSteps);
    env->SetObjectArrayElement(arrPS, i, procSolObj);
}