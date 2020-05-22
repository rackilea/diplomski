boolean valid = true;
for (int i=0;i<1_000_000_000;i++) {
    long timeGenerated = System.currentTimeMillis();
    Address address = new Address(1021, "A Street", "A country", timeGenerated);
    valid = valid && address.isOk();
}
return valid;