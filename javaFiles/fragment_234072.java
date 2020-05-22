int[] listRange = fileList.getSelectedIndices();
int i = listRange.length-1;
while (i >= 0) {
    listModel.remove(listRange[i]);
    i--;
}