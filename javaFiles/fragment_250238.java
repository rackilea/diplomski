package org.apache.commons.vfs2.provider.smb.test;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.FileSystemOptions;
import org.apache.commons.vfs2.VFS;
import org.apache.commons.vfs2.auth.StaticUserAuthenticator;
import org.apache.commons.vfs2.impl.DefaultFileSystemConfigBuilder;


public class StandaloneMain
{
    public static void main(String[] args) throws FileSystemException {
        //jcifs.Config.registerSmbURLHandler();
        StaticUserAuthenticator auth = new StaticUserAuthenticator("DOMAIN", "eckenfel", "SECRET");
        FileSystemOptions opts = new FileSystemOptions();
        DefaultFileSystemConfigBuilder.getInstance().setUserAuthenticator(opts, auth);
        FileSystemManager fs = VFS.getManager();
        if (!fs.hasProvider("smb")) throw new RuntimeException("Provide missing");
        System.out.println("Connecting " + args[0] + " with " + opts);
        FileObject smbFile = fs.resolveFile(args[0], opts); // added opts!
        System.out.println(smbFile.exists() + " " + smbFile.getContent().getLastModifiedTime());
    }
}