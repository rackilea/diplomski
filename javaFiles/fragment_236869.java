String DN = "cn="+a.get("cn").replaceAll(" ","")+",ou=Users"+",dc=example,dc=com";
Attribute dn = new BasicAttribute("dn",DN);
Attribute cn = new BasicAttribute("cn",a.get("cn"));
Attribute objectClass = new BasicAttribute("objectClass", "inetOrgPerson");
...
Attributes atts = new BasicAttributes();
atts.put(dn);
atts.put(cn);
atts.put(objectClass);
ctx.createSubcontext(DN, atts);