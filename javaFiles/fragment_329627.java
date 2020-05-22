FileInputStream localFileInputStream = new FileInputStream(paramString1);
Object localObject1 = null;
try {
    FileOutputStream localFileOutputStream = new FileOutputStream(paramString2);
    Object localObject2 = null;
    try {
        GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localFileOutputStream);
        Object localObject3 = null;
            try {
                // ... do work
           } catch (Throwable localThrowable6) {
               localObject3 = localThrowable6;
               throw localThrowable6;
           } finally {
               if (localGZIPOutputStream != null) {
                   if (localObject3 != null) {
                       try {
                           localGZIPOutputStream.close();
                       } catch (Throwable localThrowable7) {
                           localObject3.addSuppressed(localThrowable7);
                       }
                   } else {
                       localGZIPOutputStream.close();
                   }
               }
           }
       } catch (Throwable localThrowable4) {
           localObject2 = localThrowable4;
           throw localThrowable4;
       } finally {
           if (localFileOutputStream != null) {
               if (localObject2 != null) {
                   try {
                       localFileOutputStream.close();
                   } catch (Throwable localThrowable8) {
                       localObject2.addSuppressed(localThrowable8);
                   }
               } else {
                   localFileOutputStream.close();
               }
           }
       }
   } catch (Throwable localThrowable2) {
       localObject1 = localThrowable2;
       throw localThrowable2;
   } finally {
       if (localFileInputStream != null) {
           if (localObject1 != null) {
               try {
                   localFileInputStream.close();
               } catch (Throwable localThrowable9) {
                   localObject1.addSuppressed(localThrowable9);
               }
           } else {
               localFileInputStream.close();
           }
       }
   }
}