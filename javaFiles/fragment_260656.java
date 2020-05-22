Entry entry; // I don't actually know what .get() returns
entry = AddyBook.get(x);
if (entry == null)
    throw new RuntimeException("entry is null at "+x+" book size="+AddyBook.size());

Type type = entry.getContactType();
if (type == null)
    throw new RuntimeException("type is null from entry="+entry.toString());

strType = Type.toString ( );