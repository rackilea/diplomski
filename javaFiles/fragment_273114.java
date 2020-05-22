Mat m = Highgui.imread(file.getAbsolutePath());
if (img.data)
{
     showToast("Height: " + m.height() + " Width: " + m.width());
}
else
{
     // print error and abort execution
}