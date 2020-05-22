Mixer.Info[] mixerInfos = AudioSystem.getMixerInfo();
 for (Mixer.Info info: mixerInfos){
  Mixer m = AudioSystem.getMixer(info);
  Line.Info[] lineInfos = m.getSourceLineInfo();
  for (Line.Info lineInfo:lineInfos){
   System.out.println (info.getName()+"---"+lineInfo);
   Line line = m.getLine(lineInfo);
   System.out.println("\t-----"+line);
  }
  lineInfos = m.getTargetLineInfo();
  for (Line.Info lineInfo:lineInfos){
   System.out.println (m+"---"+lineInfo);
   Line line = m.getLine(lineInfo);
   System.out.println("\t-----"+line);

  }

 }