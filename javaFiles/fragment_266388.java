String url = "http://ptr.vip.host.com/pss/repositories/pssdb/branches/main/query/Service[@alias="
            + "hello"
            + "].serviceInstances.runsOn{@resourceId}?allowScan=true&limit=10000&skip=0";
UriComponentsBuilder builder = UriComponentsBuilder.fromPath(url);
UriComponents uriComponents = builder.build();
URI uri = uriComponents.toUri();