LDAPAttributeSet attributeSet = new LDAPAttributeSet();

String rolesName;
String uniquemem[] = rolesName.split(",");

String item = null;
String arrayItems[uniquemem.length]

for(int i=0; i<uniquemem.length; i++) {
    item = "cn=" + uniquemem[i];
    arrayItems[i] = item;
}


attributeSet.add(new LDAPAttribute("uniqueMember", arrayItems);