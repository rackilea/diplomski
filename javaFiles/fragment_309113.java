int var1 = 3;
int var2 = 1;
boolean result1;
while ((result1 = var1 != 0) && var2 != var1) {
    var1--;
}
if (result1) {
    // It was the "var2 != var1" condition that ended the loop
} else {
    // It was the "va1 != 0" condition that ended the loop
}