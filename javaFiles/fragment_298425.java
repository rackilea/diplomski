StringBuilder sb= new StringBuilder();
 String sampleLine;
 try(BufferedReader sampleBuffer = new BufferedReader(new FileReader("./test.xml"))) {
        while ((sampleLine = sampleBuffer.readLine()) != null) {
          sb.append(sampleLine);
            }
 } catch (Exception e) {
            e.printStackTrace();
  }
//System.out.println(sb.toString());

String content=sb.toString();
String data[]=content.split("<ns3:transaction id=\"74608009\" amount=\"-200.00\" requestedAmount=\"-200.00\" status=\"COMPLETE\">|</ns3:transaction>");
// System.out.println(data[1]+"\n\n");
String seconddata[]=data[1].split("<ns3:walletType>|</ns3:walletType>");
String walletType=seconddata[1];
System.out.println("Wallet Type: "+walletType);