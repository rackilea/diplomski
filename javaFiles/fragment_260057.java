boolean equalStr(String str1, String str2)
{
   if((str1 != null && str2 == null) || (str1 == null && str2 != null))
       return false;

   if(str1 == null && str2 == null)
       return true;

   return str1.trim().equals(str2.trim());
}