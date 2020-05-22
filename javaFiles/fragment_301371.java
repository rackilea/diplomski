int val = 0;
if (user) val |= 0x1;
if (pass) val |= 0x2;

switch (val) {
case 0: // Both too short
case 1: // User Ok, pass too short
case 2: // User too short, pass ok
case 3: // Both Ok
}