unsigned short text[100];
// fill text with UTF-16; make sure that all characters are 2 bytes long
long utf32[100];
for (int i=0; i<100; i++)
  utf32[i] = text[i];

__android_log_print(ANDROID_LOG_INFO, "UTF-32", "%ls", utf32);