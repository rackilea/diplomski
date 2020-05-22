Attribute attr1 = holder.getAttributes()[i];

ASN1Set values1 = attr1.getAttrValues();

RoleSyntax rl = RoleSyntax.getInstance(attr1.getAttrValues().getObjectAt(0));
System.out.println(rl);