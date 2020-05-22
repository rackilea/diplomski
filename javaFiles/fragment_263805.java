public Assets assets;
public Texture Stuff;

public mainMenu(){
     assets = new Assets();  // why are you creating new Assets here
     Stuff = assets.manager.get(assets.stuff);
}