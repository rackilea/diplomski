JNIEXPORT jobject JNICALL Java_net_sf_clipsrules_jni_Environment_getFactSlot(
  JNIEnv *env,
  jclass javaClass, 
  jobject javaEnv,
  jlong clipsEnv,
  jlong clipsFact,
  jstring slotName)
  {
   jobject rv;
   DATA_OBJECT theDO;
   void *theCLIPSEnv = JLongToPointer(clipsEnv);
   const char *cSlotName = NULL;

   if (slotName != NULL)
     { cSlotName = (*env)->GetStringUTFChars(env,slotName,NULL); }

   void *oldContext = SetEnvironmentContext(theCLIPSEnv,(void *) env);

   EnvGetFactSlot(JLongToPointer(clipsEnv),JLongToPointer(clipsFact),(char *) cSlotName,&theDO);

   if (slotName != NULL)
     { (*env)->ReleaseStringUTFChars(env,slotName,cSlotName); }

   rv = ConvertDataObject(env,javaEnv,theCLIPSEnv,&theDO);

   SetEnvironmentContext(JLongToPointer(clipsEnv),oldContext);

   return rv;
  }