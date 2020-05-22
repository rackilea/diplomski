for( int i = 0; i < stringCount; ++i )
{
   jstring arrElement = (jstring) (env->GetObjectArrayElement(jParameters, i));
   const char* nativeElement = env->GetStringUTFChars( arrElement, NULL);
   CallCfunction( nativeElement ); // modified to process an item not a list<
   env->ReleaseStringUTFChars(arrElement, nativeElement);
}