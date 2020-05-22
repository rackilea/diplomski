package versioncheck;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

public class CheckAgent implements ClassFileTransformer
{
  public static void premain(String agentArgs, Instrumentation inst)
  {
    inst.addTransformer(new CheckAgent(), inst.isRetransformClassesSupported());
  }
  public static void agentmain(String agentArgs, Instrumentation inst)
  {
    inst.addTransformer(new CheckAgent(), inst.isRetransformClassesSupported());
  }
  private int supported;
  CheckAgent()
  {
    supported=(int)Double.parseDouble(System.getProperty("java.class.version"));
  }
  public byte[] transform(ClassLoader loader, String className,
      Class<?> classBeingRedefined, ProtectionDomain protectionDomain,
      byte[] classfileBuffer) throws IllegalClassFormatException
  {
    int version=(classfileBuffer[6]&0xff)<<8 | (classfileBuffer[7]&0xff);
    if(version>supported)
      System.out.println(className+" v"+version+" from "
      +protectionDomain.getCodeSource());
    return null;
  }
}