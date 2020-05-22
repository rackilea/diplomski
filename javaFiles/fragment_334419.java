boolean wantToSeeThis = true;

...

void render() {
   batcher.begin();
   (blah blah blah)
   if (wantToSeeThis) {
       AssetLoader.font.draw(batcher, "Hey guys", x, y);
   }
}

void hideIt() {
   wantToSeeThis = false;
}