ASN1Sequence seq2 = (ASN1Sequence) responseASN1.getObjectAt(0); // get sequence 2
// ignore sequence 3, because tag 12 is in CONTEXT SPECIFIC 
DERTaggedObject contextSpecific = (DERTaggedObject) seq2.getObjectAt(1); // the second element of sequence 2
ASN1Sequence seq5 = (ASN1Sequence) contextSpecific.getObject(); // get sequence 5
ASN1Sequence seq6 = (ASN1Sequence) seq5.getObjectAt(0); // get sequence 6
ASN1Sequence seq7 = (ASN1Sequence) seq6.getObjectAt(0); // get sequence 7
ASN1Sequence seq8 = (ASN1Sequence) seq7.getObjectAt(1); // get sequence 8 (second element of sequence 7)
DERUTF8String utf8String = (DERUTF8String) seq8.getObjectAt(0); // finally get the UTF8String
System.out.println(utf8String.getString()); // the string you want