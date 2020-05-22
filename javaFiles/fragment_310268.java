int numberLength = 0;
int instanceNumber = number;
while (instanceNumber > 0) {
    ++numberLength;
    instanceNumber /= 10;
}