/Applications/NetLogo 5.0.5 % scala29 -Yrepl-sync -classpath NetLogo.jar
Welcome to Scala version 2.9.3 (Java HotSpot(TM) 64-Bit Server VM, Java 1.7.0_51).

scala> val applet = new org.nlogo.lite.Applet
applet: org.nlogo.lite.Applet = ...

scala> applet.init()
...

scala> val ws = applet.panel.workspace: org.nlogo.window.GUIWorkspace
ws: org.nlogo.window.GUIWorkspace = org.nlogo.lite.LiteWorkspace@69cafecd

scala> import collection.JavaConverters._
import collection.JavaConverters._

scala> Thread.getAllStackTraces().keySet.asScala.foreach(println)
Thread[JobThread,4,main]
Thread[Lifeguard,6,main]
...

scala> ws.jobManager.haltPrimary()

scala> ws.jobManager.die()

scala> import util.Try
import util.Try

scala> for {
         thread <- Thread.getAllStackTraces().keySet.asScala
         if thread.getName == "Lifeguard"
         outer = Try{ val field = thread.getClass.getDeclaredField("this$0")
                      field.setAccessible(true)
                      field.get(thread) }
         if outer.toOption == Some(ws)
       } {
         thread.interrupt()
         thread.join()
       }
Success(org.nlogo.lite.LiteWorkspace@69cafecd)

scala> Thread.getAllStackTraces().keySet.asScala.foreach(println)
...