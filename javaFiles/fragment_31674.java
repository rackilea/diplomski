public static void displayMixerInfo()
{
  Mixer.Info [] mixersInfo = AudioSystem.getMixerInfo();

  for (Mixer.Info mixerInfo : mixersInfo)
   {
     System.out.println("Mixer: " + mixerInfo.getName());

     Mixer mixer = AudioSystem.getMixer(mixerInfo);

     Line.Info [] sourceLineInfo = mixer.getSourceLineInfo();
     for (Line.Info info : sourceLineInfo)
       showLineInfo(info);

     Line.Info [] targetLineInfo = mixer.getTargetLineInfo();
     for (Line.Info info : targetLineInfo)
       showLineInfo(info);
   }
}


private static void showLineInfo(final Line.Info lineInfo)
{
  System.out.println("  " + lineInfo.toString());

  if (lineInfo instanceof DataLine.Info)
   {
     DataLine.Info dataLineInfo = (DataLine.Info)lineInfo;

     AudioFormat [] formats = dataLineInfo.getFormats();
     for (final AudioFormat format : formats)
       System.out.println("    " + format.toString());
   }
}