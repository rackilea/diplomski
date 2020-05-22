class Tile{
        /* Rest of Class*/
        //Additions
    public Image getSprite() {
        return sprite;
    }
    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }

}

//Mock
class Image{
    public String name;
    public Image(String name){
        this.name = name;
    }
}