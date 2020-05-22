import xmlrpclib

conn_settings = \
{
    "user" : "noob",
    "pass" : "1234",
    "host" : "localhost",
    "port" : 8080,
    "path" : ""
}

conn_str = "http://" + ("%(user)s:%(pass)s@" % conn_settings if(conn_settings.get("user", "")) else "") + "%(host)s:%(port)d%(path)s" % conn_settings
print "Connecting using: %s" % conn_str

client = xmlrpclib.ServerProxy(conn_str)

print "You can call this"
print client.system.listMethods()

print "Trying Query"
print client.ContentAPI.queryResult("1376")