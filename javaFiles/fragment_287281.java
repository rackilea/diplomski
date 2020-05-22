Integer zero = new Integer(0);
for (Integer i : hm.values()) {
    if (!zero.equals(i)) {
        System.out.println("found one non-zero value");
        break;
    }
}