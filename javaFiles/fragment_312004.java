int fare = 0;
int distance = 0;
if (distance > 21) {
    fare += (distance - 21) * 25;
    distance = 21;
}
if (distance > 11) {
    fare += (distance - 11) * 35;
    distance = 11;
}
if (distance > 1) {
    fare += (distance - 1) * 45;
    distance = 1;
}
if (distance > 0) {
    fare += distance * 50;
}