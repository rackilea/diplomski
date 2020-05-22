Date from = new Date();
Date to = new Date(System.currentTimeMillis()+ 30*1000*60*60l);

ASN1EncodableVector v = new ASN1EncodableVector();
DERGeneralizedTime fromTime = new DERGeneralizedTime(from);    
v.add(new DERTaggedObject(false, 0, fromTime));

DERGeneralizedTime toTime = new DERGeneralizedTime(to);    
v.add(new DERTaggedObject(false, 1, toTime));

DERObject o = new DERSequence(v);    
PrivateKeyUsagePeriod pkup = PrivateKeyUsagePeriod.getInstance(o);    
v3CertGen.addExtension(x509Extensions.PrivateKeyUsagePeriod, false, pkup);