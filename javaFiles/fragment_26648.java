ChannelSftp sftp = (ChannelSftp) channel;
sftp.cd(hostDir);
Vector<String> files = sftp.ls("*");
for (int i = 0; i < files.size(); i++)
{
    Object obj = files.elementAt(i);
    if (obj instanceof com.jcraft.jsch.ChannelSftp.LsEntry)
    {
        LsEntry entry = (LsEntry) obj;
        if (true && !entry.getAttrs().isDir())
        {
            ret.add(entry.getFilename());
        }
        if (true && entry.getAttrs().isDir())
        {
            if (!entry.getFilename().equals(".") && !entry.getFilename().equals(".."))
            {
                ret.add(entry.getFilename());
            }
        }
    }
}
System.out.println(ret);