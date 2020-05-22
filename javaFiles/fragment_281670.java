// Space to store last error ////////////////////////////////////////////
static DWORD dwTlsIndexLastError = 0;

BOOL WINAPI DllMain(
  _In_  HINSTANCE hinstDLL,
  _In_  DWORD fdwReason,
  _In_  LPVOID lpvReserved
){


    switch(fdwReason){
    case DLL_PROCESS_ATTACH:
        dwTlsIndexLastError = TlsAlloc();
        break;
    case DLL_PROCESS_DETACH:
        TlsFree(dwTlsIndexLastError);
        dwTlsIndexLastError = 0;
        break;
     }
     return TRUE;
}

///// Save the last error. 
///// Call this function after the "real" function whose error you want to report.
void SaveLastError()
{
    TlsSetValue(dsTlsIndexLastError, (LPVOID)(DWORD_PTR)GetLastError());
} 
// GetLastError ////////////////////////////////////////////////////////////
JNIEXPORT jint JNICALL
Java_org_xidobi_OS_GetLastError(JNIEnv *env, jobject this) {
    return (jint)  TlsGetValue(dsTlsIndexLastError);
}

// CreateFile ////////////////////////////////////////////////////////////
JNIEXPORT jint JNICALL
Java_org_xidobi_OS_CreateFile(JNIEnv *env, jobject this,
    jstring lpFileName,
    jint dwDesiredAccess,
    jint dwShareMode,
    jint lpSecurityAttributes,
    jint dwCreationDisposition,
    jint dwFlagsAndAttributes,
    jint hTemplateFile) {

const char* fileName = (*env)->GetStringUTFChars(env, lpFileName, NULL);

HANDLE handle = CreateFile(fileName,
                            dwDesiredAccess,
                            dwShareMode,
                            (LPSECURITY_ATTRIBUTES) lpSecurityAttributes,
                            dwCreationDisposition,
                            dwFlagsAndAttributes,
                            (HANDLE) hTemplateFile);

// Save the value of GetLastError for the relevant function
SaveLastError();

(*env)->ReleaseStringUTFChars(env, lpFileName, fileName);

return (jint) handle;
}