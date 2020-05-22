int window = 1;
int wp = 0;
for (Testdata td : list) {
  if (td.window > window) {
    wp = 1;
    window = td.window;
  } else {
    wp++;
  }

  td.windowposition = wp;
}