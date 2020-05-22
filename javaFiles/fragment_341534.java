#!/usr/bin/env node
//--------------------------------------------------------------------
// Simple multi-MFP launcher script
// Karl Bishop <kfbishop@us.ibm.com>
//--------------------------------------------------------------------
var spawn  = require('child_process').spawn;
var MFP_HOME = process.env.HOME + "/dev/mobilefirst",
    MFP_CMD = MFP_HOME+"/mobilefirst-cli/bin/mobilefirst-cli.js",
    JAVA_HOME = "/Library/Java/JavaVirtualMachines/jdk1.7.0_55.jdk/Contents/Home";

process.env['JAVA_HOME'] = JAVA_HOME;
process.env['PATH']      = JAVA_HOME+"/bin:" + process.env['PATH'];
console.log("Using Java:", CFG.JAVA_HOME);        //-- Launch custom MFP
spawn( MFP_CMD, args, { stdio:'inherit' } );