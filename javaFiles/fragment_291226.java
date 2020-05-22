String str = "-High Upload Observed|High| eventId=285475664495 MMTT type=2 mrt=1482650158658 in=104858769 out=104858769 sessionId=0 generatorID=3+ACVIFkBABCAA951mZ0UyA\\=\\= modelConfidence=0 severity=0\" output : eventId=285475664495 MMTT type=2 mrt=1482650158658 in=104858769 out=104858769 sessionId=0 generatorID=3+ACVIFkBABCAA951mZ0UyA\\=\\= modelConfidence=0 severity=0";
Pattern p = Pattern.compile("[^ ]+=[^ ]+");
Matcher m = p.matcher(str.split("\"")[0]);
while (m.find()) {
    System.out.println(m.group());
}