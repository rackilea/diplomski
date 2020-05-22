run {
    args = [
            'run', mainVerticleName,
            "-conf", confPath,
            "--redeploy=$project.ext.watchForChange",
            "--launcher-class=$mainClassName",
            "--on-redeploy=$project.ext.doOnChange",
            // used for attaching remote debugger
            "--java-opts", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000"
    ]
}