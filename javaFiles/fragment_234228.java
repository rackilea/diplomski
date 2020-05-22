Obj p = curScope.locals, last = null;
while (p != null) {
    if (p.name.equals(name)) {
        error(name + " declared twice");
        last = p;
        p = p.next;
    }
}
if (last == null) {
    curScope.locals = obj; 
} else {
    last.next = obj;
}