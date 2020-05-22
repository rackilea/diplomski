id delegateObject; // Assume this exists.
NSNetServiceBrowser *serviceBrowser;

serviceBrowser = [[NSNetServiceBrowser alloc] init];
[serviceBrowser setDelegate:delegateObject];
[serviceBrowser searchForServicesOfType:@"_http._tcp" inDomain:@""];