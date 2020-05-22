int elements = data.length;
int mod = elements % 3;
int div = elements / 3;

int sizeLeft = div + (mod > 0 ? 1 : 0);
int sizeCenter = div;
int sizeRight = div + (mod > 1 ? 1 : 0);