if(flag)
{
    if (event == XmlPullParser.START_TAG && xpp.getName().equalsIgnoreCase("Child"))
      System.out.println(xpp.getText());
}
}
}
if (event == XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase("Level"))
{
    flag = false;
}