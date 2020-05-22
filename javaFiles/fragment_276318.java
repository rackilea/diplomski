char newline_character = <whatever is appropriate for your file>;
int line = 0;
while ((i = fileInput.read()) != -1) {
   char a = (char) i;
   if (a==newline_character) { ++line; }
}