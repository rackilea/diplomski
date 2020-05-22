long operand1 = ...
long operand2 = ...
long bitMask = Long.MAX_VALUE; // bits 0-62 set, bit 63 clear
int conditions = 0;
if (operand1 < 0)
    ++conditions; 
if (operand2 < 0)
    ++conditions;
if (((operand1 & bitMask) + (operand2 & bitMask)) < 0)
    ++conditions;
if (conditions > 1)
    System.out.println("carry would be set!");