public final Path getPath(String paramString, String... paramVarArgs)
{
  String str1;
  if (paramVarArgs.length == 0) {
    str1 = paramString;
  } else {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    for (String str2 : paramVarArgs) {
      if (str2.length() > 0) {
        if (localStringBuilder.length() > 0)
          localStringBuilder.append('\\');
        localStringBuilder.append(str2);
      }
    }
    str1 = localStringBuilder.toString();
  }
  return WindowsPath.parse(this, str1);
}