float f = 1000f;
int i = 3; 

f = i; // Ok
i = f; // Error

f = i/f; //Ok 0.003
f = f/i; //Ok 333.3333(3)

i = i/f; //Error
i = f/i; //Error