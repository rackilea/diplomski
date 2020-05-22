jstring WindowsToJstring(JNIEnv* pEnv, char* cstr) {
   jstring retJstring = NULL;
   int slen = strlen(cstr);
   int length = MultiByteToWideChar( CP_ACP, 0, (LPCSTR)cstr, slen, NULL, 0 );
   unsigned short* tempbuffer = (unsigned short *)malloc( length*2 + 1 );
   MultiByteToWideChar( CP_ACP, 0, (LPCSTR)cstr, slen, (LPWSTR)tempbuffer, length );
   retJstring = (pEnv)->NewString((jchar*)tempbuffer, length );
   free( tempbuffer );
   return retJstring;
}