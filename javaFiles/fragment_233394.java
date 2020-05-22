// count the numbers less than 500
int count = 0;
for(int x = 0; x < slumptal.length; x++) {
  if(slumptal[x] < 500)
    count++;
}
slumptalMindre = new int[count];

int y = 0; // Index to access array slumptalMindre
for(int x = 0; x < slumptal.length; x++) {
  if(slumptal[x] < 500)
    slumptalMindre[y++] = slumptal[x]; 
}