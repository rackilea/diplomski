double timer = 0;
int size = 0;
while(true) {
  final finalSize = size;
  timer = time(() -> functionB(finalSize));
  size *= 10;
}