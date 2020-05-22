class Sprite {
    public enum SpriteType {
         BOX, CAT, BOTTLE, HUMAN, TARGET, /* ... */, SIMPLE;
    }

    public SpriteType getSpriteType(){
       return SIMPLE;
    }
}


class Box extends Sprite {
    @Override
    public SpriteType getSpriteType(){
       return Sprite.SpriteType.BOX;
    }
}