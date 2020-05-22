String input = "2014<>10.100.2.3<><189>date=2014-01-16,time=11:26:14,devname=B3909601569,devid=B3909601569,logid=000013,type=traffic,srcip=192.168.192.123,srcport=2072,srcintf=port2,dstip=10.180.1.105,dstport=3206,dstintf=port1,sessionid=121543,status=close,policyid=196,service=MYSQL,proto=6,duration=10,sentbyte=3910,rcvdbyte=175085,sentpkt=74,rcvdpkt=132";
    Pattern p = Pattern.compile("srcport=(\\d+).*?dstport=(\\d+)"); // update regex
    Matcher m = p.matcher(input);

    StringBuffer result=new StringBuffer();

    while (m.find()) {

        System.out.println("Srcport: " + m.group(1)); //print groups 1 + 2
        System.out.println("Dstport: " + m.group(2));

    }

    System.out.println(result);