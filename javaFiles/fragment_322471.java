public class OpensslIntToBigInteger {

    public static BigInteger opensslBigToBigInteger(String opensslInt)
    {
        String hexInt = opensslInt.replaceAll(":", "");
        hexInt = hexInt.replaceAll("\\s+", "");
        return new BigInteger(hexInt, 16);
    }
    public static void main(String[] args) {

        String opensslInt = 
                "        00:98:10:23:16:ff:b6:f4:26:a2:42:a6:19:23:0e:\n" +
                "        0f:27:4a:b9:43:3d:a0:4b:b9:1b:1a:57:92:dd:a8:\n" + 
                "        bc:5d:b8:6e:e6:7f:0f:2e:89:a5:77:16:d1:cf:44:\n" + 
                "        69:74:2b:b1:a9:dd:72:bd:a8:9c:aa:90:ca:7b:f4:\n" + 
                "        d3:d3:db:11:98:bd:61:f1:2c:77:41:ad:c4:42:6a:\n" + 
                "        88:d1:37:04:12:a9:36:ec:09:34:0d:31:71:b9:5a:\n" + 
                "        ea:ed:ce:61:1c:1e:5f:6c:9e:28:ee:21:2a:e4:c6:\n" + 
                "        1f:75:29:78:a5:96:b1:53:17:4d:bf:88:d1:12:5c:\n" + 
                "        a6:75:aa:7c:fe:23:a8:dd:25:35:46:c6:8a:eb:2e:\n" + 
                "        e4:a3:1d:7f:b6:6d:9c:7d:66:59:84:c9:51:15:82:\n" + 
                "        67:a6:85:e9:c8:d6:2b:a7:e6:28:08:d2:b1:99:92:\n" + 
                "        67:32:c4:ba:f7:c9:1a:16:30:e5:cb:39:cb:96:28:\n" + 
                "        70:32:ba:18:d2:64:2f:74:3e:dd:09:e0:68:56:57:\n" + 
                "        cf:50:63:c0:95:a9:b0:5b:2a:ad:21:4f:bd:e7:15:\n" + 
                "        64:4a:9d:e4:c5:c3:5c:35:bf:e6:78:f4:8a:40:83:\n" + 
                "        da:7d:0d:6c:02:60:4a:3f:0c:9c:03:fd:48:e6:72:\n" + 
                "        f3:0d:5b:90:6b:de:59:58:c9:f4:26:4a:61:b4:52:\n" + 
                "        21:1d";

        BigInteger modulus = opensslBigToBigInteger(opensslInt);
        System.out.println(modulus.toString(16));
    }
}