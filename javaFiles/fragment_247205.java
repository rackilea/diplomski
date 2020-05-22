package org.example.scp;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.optional.ssh.Scp;

public class ScpCopyExample {

    public void downloadFile( String remoteFilePath, String localFilePath ) {
        Scp scp = new Scp();
        scp.setFile("username:password@host.example.org:" + remoteFilePath);
        scp.setLocalTofile(localFilePath);
        scp.setProject(new Project()); // prevent a NPE (Ant works with projects)
        scp.setTrust(true); // workaround for not supplying known hosts file

        scp.execute();
    }

    public static void main(String[] args) {
        ScpCopyExample scpDemo = new ScpCopyExample();
        scpDemo.downloadFile("~/test.txt", "testlocal.txt");
    }

}