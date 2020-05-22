// After getting URL from Web-View as 'myUrl'...Try this

// Get the Query part
String str = myUrl.getQuery();

// Get everything after '='
requiredStr = str.substring(str.indexOf('='));