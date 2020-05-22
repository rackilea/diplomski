public java.lang.String[] list()
                        throws SmbException

    List the contents of this SMB resource. The list returned by this method will be;

        files and directories contained within this resource if the resource is a normal disk file directory,
        all available NetBIOS workgroups or domains if this resource is the top level URL smb://,
        all servers registered as members of a NetBIOS workgroup if this resource refers to a workgroup in a smb://workgroup/ URL,
        all browseable shares of a server including printers, IPC services, or disk volumes if this resource is a server URL in the form smb://server/,
        or null if the resource cannot be resolved. 

    Returns:
        A String[] array of files and directories, workgroups, servers, or shares depending on the context of the resource URL 
    Throws:
        SmbException