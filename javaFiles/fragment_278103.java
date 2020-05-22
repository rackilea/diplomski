Attribute attr1 = holder.getAttributes()[i];
Attribute attr2 = att.getAttributes()[i];

ASN1Set values1 = attr1.getAttrValues();
System.out.println(values1.getObjectAt(0).getClass());
ASN1Set values2 = attr2.getAttrValues();
System.out.println(values2.getObjectAt(0).getClass());