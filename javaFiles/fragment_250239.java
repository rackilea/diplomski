> set REP=C:\Users\USERNAME\.m2\repository
> java -cp sandbox\target\commons-vfs2-sandbox-2.0.jar;^
           core\target\commons-vfs2-2.0.jar;^
           %REP%\commons-logging\commons-logging\1.1.1\commons-logging-1.1.1.jar;^
           %REP%\jcifs\jcifs\0.8.3\jcifs-0.8.3.jar;^
           sandbox\target\test-classes
       org.apache.commons.vfs2.provider.smb.test.StandaloneMain smb://HOST/Users
Jan 05, 2015 2:40:19 PM org.apache.commons.vfs2.VfsLog info
INFORMATION: Using "C:\Users\USERNAME\AppData\Local\Temp\vfs_cache" as temporary files store.
Connecting smb://eckenfels02/Users with org.apache.commons.vfs2.FileSystemOptions@27dd2ec5
true 0