Map<String, String> nsMap = new HashMap<String, String>();
nsMap.put( "ns", "http://myuri.com" );

from("file://path")
.filter().xpath("ns:serviceName eq 'enquiry'", nsMap )
.to(url);