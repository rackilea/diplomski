private static Object get(Scriptable scope, String name) {
    Scriptable cur = scope;
    for (String part : StringUtils.split(name, ".")) {
        Object next = cur.get(part, scope);
        if (next instanceof Scriptable) {
            cur = (Scriptable) next;
        } else {
            return null;
        }
    }
    return cur;
}