int i = 0;

boolean valueChanged = false;

while(some good condition) {
    if (i % 100 == 0) {
        i++;
        valueChanged = true;
    }
}

if(valueChanged) {
   System.out.println("Changed :D");
}