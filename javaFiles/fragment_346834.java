String value = ("false || true && true && false || true");
boolean result = false;
for (String conj : value.split("\\|\\|")) {
    boolean b = true;
    for (String litteral : conj.split("&&"))
        b &= Boolean.parseBoolean(litteral.trim());
    result |= b;
}
System.out.println(result); // prints true