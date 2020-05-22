ImageIcon ii = new ImageIcon(originalFile.getCanonicalPath());

if(ii.getImageLoadStatus() == MediaTracker.COMPLETE)
{
    System.out.print("Load image ok\n");
}
else
{
    System.out.print("Load image failed\n");
}