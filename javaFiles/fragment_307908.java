String tmp = "";
bool flag = true;
for(char c : input.toCharArray()) {
   if(flag) {
      tmp = c + tmp;
   } else {
      tmp = tmp + c;
   }
   flag = !flag;
}