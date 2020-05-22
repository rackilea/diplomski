int a = first position of non-space;
int b = a;

while b < s.size() {
  if (a != b) {
    s[a] = s[b]
    s[b] = ' '
  }
  if (both s[a] and s[a-1] are space)  { 
    increment b;
    // leave a untouched
  } else {
    increment a;
    increment b;
  }
}