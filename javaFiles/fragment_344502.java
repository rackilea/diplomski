diff -aur a/native/jni/java-nio/gnu_java_nio_VMChannel.c b/native/jni/java-nio/gnu_java_nio_VMChannel.c
--- a/native/jni/java-nio/gnu_java_nio_VMChannel.c  2007-12-28 18:49:56.000000000 +0100
+++ b/native/jni/java-nio/gnu_java_nio_VMChannel.c  2012-08-14 08:49:38.000000000 +0200
@@ -868,6 +868,17 @@

   elems = (*env)->GetByteArrayElements (env, addr, NULL);

+  int n = 1;
+
+  if (*((uint32_t *) elems) == 0xFFFFFFFF)
+  {
+    if (setsockopt(fd, SOL_SOCKET, SO_BROADCAST, (char *) &n, sizeof(n)) == -1)
+    {
+      JCL_ThrowException (env, IO_EXCEPTION, "unable to set broadcast option");
+      return -1;
+    }
+  }
+
   sockaddr.sin_family = AF_INET;
   sockaddr.sin_addr.s_addr = *((uint32_t *) elems);
   sockaddr.sin_port = htons (port);