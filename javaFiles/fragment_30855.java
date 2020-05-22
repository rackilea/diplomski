try {
Url uri = new Url(urlString);
Parser parse = new Parser(uri);
} catch (SocketTimeOutException  e) {
//I want to cache this ecption and do some thing or  restart based 
//if its timeout issue
//am using  proxy for the network connection at JVM setting
//using setProperty
} catch (Exception  e) {
//ingnore some other excpetions
}