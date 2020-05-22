temp6 = vars.get("host_2_g1");

if (temp6 != null) {
    OUT.write(temp6.getBytes());
}
else {
    OUT.write("host_2_g1 is null".getBytes());
}