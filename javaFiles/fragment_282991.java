@Grab(group='org.apache.ant', module='ant-javamail', version='1.9.4')
@Grab(group='javax.activation', module='activation', version='1.1.1')
@Grab(group='javax.mail', module='mail', version='1.4.7')
@GrabConfig(systemClassLoader=true)

// ...

public void send(File[] files) {
    String filesString = ""
    for (int i = 0; i < files.size(); i++) {
        filesString += f.canonicalPath
        if (files.size() > 1 && i < files.size() -1)
            filesString += ","
    }
    ant.mail(
        from: "IMSBatch@vanguard.com",
        tolist: to,
        message: msg,
        subject: subject,
        mailhost: host,
        messagemimetype: "text/html",
        files: filesString
    )
}