public boolean conflict(String dir) {
    if (dir.equals("down")) {
        for(Cube cubes : Panel.cubes) {
            if(this.hashCode() != cubes.hashCode()) {
                if(this.y + 18 == cubes.y && this.x == cubes.x || this.y >= Main.height - 18*4) {
                    this.conflict = true;
                    break;
                } else {
                    this.conflict = false;
                }
            }
        }
    }

    return this.conflict;
}