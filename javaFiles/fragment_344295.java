EnumPresence p1 = user1.getState();
EnumPresence p2 = user2.getState();
int comp = p1.compareTo(p2);
if (comp != 0) {
    return comp;
}
String name1 = user1.getUsername();
String name2 = user2.getUsername();
return name1.compareToIgnoreCase(name2);