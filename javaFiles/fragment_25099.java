int getType() {
  return bb.getInt(2); // offset 2
}

void setType(int type) {
  bb.putInt(2, type);
}