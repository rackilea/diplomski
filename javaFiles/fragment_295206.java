> db.version()
2.4.6
> db.version
function (){
    return this.serverBuildInfo().version;
}
> db.serverBuildInfo
function (){
    return this._adminCommand( "buildinfo" );
}
> db.runCommand('buildinfo')
{
    "version" : "2.4.6",
    "gitVersion" : "b9925db5eac369d77a3a5f5d98a145eaaacd9673",
    "sysInfo" : "Linux ip-10-2-29-40 2.6.21.7-2.ec2.v1.2.fc8xen #1 SMP Fri Nov 20 17:48:28 EST 2009 x86_64 BOOST_LIB_VERSION=1_49",
    "loaderFlags" : "-fPIC -pthread -rdynamic",
    "compilerFlags" : "-Wnon-virtual-dtor -Woverloaded-virtual -fPIC -fno-strict-aliasing -ggdb -pthread -Wall -Wsign-compare -Wno-unknown-pragmas -Winvalid-pch -Werror -pipe -fno-builtin-memcmp -O3",
    "allocator" : "tcmalloc",
    "versionArray" : [
        2,
        4,
        6,
        0
    ],
    "javascriptEngine" : "V8",
    "bits" : 64,
    "debug" : false,
    "maxBsonObjectSize" : 16777216,
    "ok" : 1
}