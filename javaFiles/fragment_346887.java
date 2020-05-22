public static String encode(String s)
  {
    try { return URLEncoder.encode(s,"UTF-8"); }
    catch (UnsupportedEncodingException e)
    {
      Resume_App.Save_To_Log("UTF-8 is not a recognized encoding\n"+Tool_Lib_Simple.Get_Stack_Trace(e));
      throw new RuntimeException(e);
    }
  }