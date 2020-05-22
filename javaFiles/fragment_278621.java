int offset;
int P1, P2;

while (continueReading)
{
    // ...
    P1 = (offset >> 8) & 0xFF;
    P2 = offset & 0x00FF;
    // ...
    // send APDU
}