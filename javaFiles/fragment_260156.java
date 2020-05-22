task adminClient() << {
    // look for -Dbuild.flash on command-line
    def buildFlash = ant.properties['build.flash']

    if (buildFlash) {
        ant.echo(message: "Building AdminClient.swf")

        ant.exec(executable: "{mxmlc.exe}", dir: "${basedir}", failonerror: "true") {
            arg(line: " '${adminClient.src.module}'")
            arg(line: " -load-config='${build.dir}/ozswfconfig.xml'")
            arg(line: " -load-config+='${build.dir}/license.xml'")
            arg(line: " -output '${package.dir}/AdminClient.swf'")
            arg(line: " -library-path+='${external.lib.dir}/PureMVC_AS3_MultiCore_1_0_4.swc'")
            arg(line: " -library-path+='${flexCommon.lib}'")
            arg(line: " -source-path '${adminClient.src.dir}'")
        }
    } else {
        // build each tab separatley for new ui 
        ant.exec(executable: "${mxmlc.exe}", dir: "${basedir}", failonerror: "true") {
            arg(line: " '${adminClient.src.dir}/ConfigurationApp.mxml'")
            arg(line: " -load-config='${build.dir}/ozswfconfig.xml'")
            arg(line: " -load-config+='${build.dir}/license.xml'")
            arg(line: " -output '${package.dir}/ConfigurationApp.swf'")
            arg(line: " -library-path+='${external.lib.dir}/PureMVC_AS3_MultiCore_1_0_4.swc'")
            arg(line: " -library-path+='${flexCommon.lib}'")
            arg(line: " -source-path '${adminClient.src.dir}'")
        }

        ant.exec(executable: "${mxmlc.exe}", dir: "${basedir}", failonerror: "true") {
            arg(line: "'${adminClient.src.dir}/LargeResultsApp.mxml'")
            arg(line: " -load-config='${build.dir}/ozswfconfig.xml'")
            arg(line: " -load-config+='${build.dir}/license.xml'")
            arg(line: " -output '${package.dir}/LargeResultsApp.swf'")
            arg(line: " -library-path+='${external.lib.dir}/PureMVC_AS3_MultiCore_1_0_4.swc'")
            arg(line: " -library-path+='${flexCommon.lib}'")
            arg(line: " -source-path '${adminClient.src.dir}'")
        }
     }
 }