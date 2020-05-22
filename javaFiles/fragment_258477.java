// Package private constructor which shares value array for speed.
String(int offset, int count, char value[]) {
this.value = value;
this.offset = offset;
this.count = count;
}