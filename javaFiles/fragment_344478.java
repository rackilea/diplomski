public badgeIMG(String path)
{
    ImageIcon ii = new ImageIcon(this.getClass().getClassLoader().getResource(path));
    badgeIcon = ii.getImage();
    badgePath = path;
}