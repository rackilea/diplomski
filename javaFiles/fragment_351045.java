String state = "";
if (temperature < 0) {
    state = "solid (ice)";
}
else if (temperature < 100) {
    state = "liquid";
}
else {
    state = "gaseous";
}