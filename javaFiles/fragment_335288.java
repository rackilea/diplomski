// Tester 
try { 
  if (crossProcessLockAcquire(SomeClassInYourApp.class, 3000)) { 
    // Success - This process now has the lock. (Don't keep it too long.) 
  } 
  else { 
    // Fail (Timeout) - Another process still had the lock after 3 seconds. 
  } 
} finally { 
  crossProcessLockRelease(); // try/finally is very important. 
} 

// Acquire - Returns success ( true/false ) 
private static boolean crossProcessLockAcquire(final Class<?> c, final long waitMS) { 
if (fileLock == null && c != null && waitMS > 0) { 
    try { 
        long dropDeadTime = System.currentTimeMillis() + waitMS; 
        File file = new File(lockTempDir, c.getName() + ".lock"); 
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw"); 
        FileChannel fileChannel = randomAccessFile.getChannel(); 
        while (System.currentTimeMillis() < dropDeadTime) { 
            fileLock = fileChannel.tryLock(); 
            if (fileLock != null) { 
                break; 
            } 
            Thread.sleep(250); // 4 attempts/sec 
        } 
    } catch (Exception e) { 
        e.printStackTrace(); 
    } 
} 
return fileLock == null ? false : true; 
} 

// Release 
private static void crossProcessLockRelease() { 
if (fileLock != null) { 
    try { 
        fileLock.release(); 
        fileLock = null; 
    } catch (IOException e) { 
        e.printStackTrace(); 
    } 
} 
} 

// Some class vars and a failsafe lock release. 
private static File lockTempDir = new File(System.getProperty("java.io.tmpdir") + File.separator + "locks"); 
private static FileLock fileLock = null; 
static { 
Runtime.getRuntime().addShutdownHook(new Thread() { 
    public void run(){ 
        crossProcessLockRelease(); 
    } 
}); 
}