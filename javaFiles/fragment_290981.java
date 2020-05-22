// the next line may be wrapped incorrectly due to MarkDown
ImageIcon a = new ImageIcon(this.getClass().getResource("../Card/AtlanticAve.jpg"));
if (a == null)
{
    System.out.println("Can not find AtlanticAve.jpg");
    return;
}
     atlantic = a.getImage();