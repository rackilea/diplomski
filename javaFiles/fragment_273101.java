Text value = "112.111.186.210 - - [20/Sep/2013:00:10:22 +0800] \"GET /structure/segment-tree HTTP/1.1\" 301 414 \"-\" \"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1;)\"","GET ", " HTTP"


     int idx = value.toString().indexOf("GET");
     int idy = value.toString().indexOf("HTTP/1");
     ip.set(value.toString().substring(idx, idy).trim());