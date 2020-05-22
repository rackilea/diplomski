String dirPath = "";
if (cbxBlackBerry.isSelected())
   dirPath = BLACKBERRY_PATH; // a constant
else {
   dirPath = "";
}
setDirectory(new File(dirPath));