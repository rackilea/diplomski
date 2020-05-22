private void recycleColums() {

if (cList.get(0).getX() + cList.get(0).getWidth() <= 0) {

    cList.remove(0);
    cList.add(7, new Column(7 + 1, false, cList.get(6).getX()));

    frame.add(cList.get(7));

  }
}