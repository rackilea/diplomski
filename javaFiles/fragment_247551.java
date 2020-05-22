SCHWERWIEGEND: Exception loading sessions from persistent storage
java.io.WriteAbortedException: writing aborted; java.io.NotSerializableException: org.dhbw.stg.wwi2008c.mopro.ui.viewscoped.MachineReservationListBean
     ...
     at org.apache.catalina.session.StandardSession.readObject(StandardSession.java:1576)
     at org.apache.catalina.session.StandardSession.readObjectData(StandardSession.java:1059)
     at org.apache.catalina.session.StandardManager.doLoad(StandardManager.java:284)
     at org.apache.catalina.session.StandardManager.load(StandardManager.java:204)
     at org.apache.catalina.session.StandardManager.startInternal(StandardManager.java:465)
     at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:140)
     ...