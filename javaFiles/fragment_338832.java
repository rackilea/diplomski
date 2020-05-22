diff --git a/core-common/src/main/java/org/glassfish/jersey/message/internal/MessageBodyFactory.java b/core-common/src/main/java/org/glassfish/jersey/message/internal/MessageBodyFactory.java
index 3845b0c..110f18c 100644
--- a/core-common/src/main/java/org/glassfish/jersey/message/internal/MessageBodyFactory.java
+++ b/core-common/src/main/java/org/glassfish/jersey/message/internal/MessageBodyFactory.java
@@ -72,6 +72,7 @@ import javax.ws.rs.ext.MessageBodyWriter;
 import javax.ws.rs.ext.ReaderInterceptor;
 import javax.ws.rs.ext.WriterInterceptor;

+import javax.annotation.Priority;
 import javax.inject.Inject;
 import javax.inject.Singleton;
 import javax.xml.transform.Source;
@@ -107,6 +108,8 @@ import jersey.repackaged.com.google.common.primitives.Primitives;
  */
 public class MessageBodyFactory implements MessageBodyWorkers {

+    private static final int DEFAULT_WORKER_PRIORITY = 1000;
+
     private static final Logger LOGGER = Logger.getLogger(MessageBodyFactory.class.getName());

     /**
@@ -218,13 +221,15 @@ public class MessageBodyFactory implements MessageBodyWorkers {
         public final T provider;
         public final List<MediaType> types;
         public final Boolean custom;
+        public final int priority;
         public final Class<?> providerClassParam;

         protected WorkerModel(
-                final T provider, final List<MediaType> types, final Boolean custom, Class<T> providerType) {
+                final T provider, final List<MediaType> types, final Boolean custom, final int priority, Class<T> providerType) {
             this.provider = provider;
             this.types = types;
             this.custom = custom;
+            this.priority = priority;
             this.providerClassParam = getProviderClassParam(provider, providerType);
         }

@@ -239,8 +244,8 @@ public class MessageBodyFactory implements MessageBodyWorkers {

     private static class MbrModel extends WorkerModel<MessageBodyReader> {

-        public MbrModel(MessageBodyReader provider, List<MediaType> types, Boolean custom) {
-            super(provider, types, custom, MessageBodyReader.class);
+        public MbrModel(MessageBodyReader provider, List<MediaType> types, Boolean custom, int priority) {
+            super(provider, types, custom, priority, MessageBodyReader.class);
         }

         public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
@@ -263,8 +268,8 @@ public class MessageBodyFactory implements MessageBodyWorkers {

     private static class MbwModel extends WorkerModel<MessageBodyWriter> {

-        public MbwModel(MessageBodyWriter provider, List<MediaType> types, Boolean custom) {
-            super(provider, types, custom, MessageBodyWriter.class);
+        public MbwModel(MessageBodyWriter provider, List<MediaType> types, Boolean custom, int priority) {
+            super(provider, types, custom, priority, MessageBodyWriter.class);
         }

         public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
@@ -437,6 +442,10 @@ public class MessageBodyFactory implements MessageBodyWorkers {
             if (modelA.custom ^ modelB.custom) {
                 return (modelA.custom) ? -1 : 1;
             }
+
+            if(modelA.priority != modelB.priority) {
+                return modelA.priority - modelB.priority;
+            }
             return 0;
         }

@@ -578,17 +587,27 @@ public class MessageBodyFactory implements MessageBodyWorkers {
         }
     }

+    private static int getPriority(Priority annotation) {
+        if (annotation == null) {
+            return DEFAULT_WORKER_PRIORITY;
+        }
+
+        return annotation.value();
+    }
+
     private static void addReaders(List<MbrModel> models, Set<MessageBodyReader> readers, boolean custom) {
         for (MessageBodyReader provider : readers) {
+            int priority = getPriority(provider.getClass().getAnnotation(Priority.class));
             List<MediaType> values = MediaTypes.createFrom(provider.getClass().getAnnotation(Consumes.class));
-            models.add(new MbrModel(provider, values, custom));
+            models.add(new MbrModel(provider, values, custom, priority));
         }
     }

     private static void addWriters(List<MbwModel> models, Set<MessageBodyWriter> writers, boolean custom) {
         for (MessageBodyWriter provider : writers) {
+            int priority = getPriority(provider.getClass().getAnnotation(Priority.class));
             List<MediaType> values = MediaTypes.createFrom(provider.getClass().getAnnotation(Produces.class));
-            models.add(new MbwModel(provider, values, custom));
+            models.add(new MbwModel(provider, values, custom, priority));
         }
     }