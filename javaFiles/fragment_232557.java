Mac mac = Mac.getInstance("HmacSHA256");
mac.init(macKey);
mac.update(part(0));
mac.update(part(1));
...
byte[] fullMac = mac.doFinal(part(9))