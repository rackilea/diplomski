if (reader.getPageRotation(i) % 180 == 0) {
    x = reader.getPageSize(i).getWidth() / 2;
    y = reader.getPageSize(i).getTop(20);
}
else {
    x = reader.getPageSize(i).getHeight() / 2;
    y = reader.getPageSize(i).getRight(20);
}