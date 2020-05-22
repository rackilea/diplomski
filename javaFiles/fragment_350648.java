Texture t = new Texture("someImage");

//Now let's say those list rows are 100 units tall and you want some room on the edges.
float height = 80;

//Calculate width taking aspect ratio in consideration
float width = height * ((float)t.width / (float)t.height);