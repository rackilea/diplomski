Object finalValue = searchValue;
try {
    finalValue = Integer.parseInt(searchValue);
} catch (Exception e) {
    // ignore
}
try {
    finalValue = parseDateFromStr(searchValue);
} catch (Exception e) {
    // ignore
}
// use finalValue as input to your logic, it will contain correct type