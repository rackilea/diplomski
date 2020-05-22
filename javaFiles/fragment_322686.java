const jchar *str = jEnv->GetStringChars(jArg2,0); 
char *cp1252 = NULL;
int len = WideCharToMultiByte(1252, 0, (LPCWSTR)str, jEnv->GetStringLength(jArg2), NULL, 0, 0, 0);
if (len > 0)
{
    cp1252 = new char[len + 1];
    WideCharToMultiByte(1252, 0, (LPCWSTR)str, jEnv->GetStringLength(jArg2), cp1252, len, 0, 0); 
    cp1252[len] = 0;
}