<cfscript>
oUrl = createobject("java", "java.net.URL").init("httP://例子.测试");
protocol = oUrl.getProtocol();
domain = oUrl.getHost();
idn = createobject("java", "java.net.IDN").toAscii(domain);
writeDump(protocol);  // -> http
writeDump(domain);    // -> 例子.测试
writeDump(idn);       // -> xn--fsqu00a.xn--0zwm56d
</cfscript>