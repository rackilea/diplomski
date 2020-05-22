int encoded = 1330;
int plusMinutes = 45;

int minutes = toMinutes(encoded);
minutes += plusMinutes;

encoded = toEncoded(minutes);