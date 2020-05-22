int go(BackHanded b) {
    if (this.state == 2) {
        b.state = 5;
        go(this);
    }
    return ++this.state;
   }
}