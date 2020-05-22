float width = cam.viewportWidth *cam.zoom;
float height = cam.viewportHeight * cam.zoom;

float w = width * Math.abs(cam.up.y) + height * Math.abs(cam.up.x);
float h = height * Math.abs(cam.up.y) + width * Math.abs(cam.up.x);
float x = cam.position.x - w / 2;
float y = cam.position.y - h / 2;

x -= offset;
w += offset;
tiledMapRenderer.setView(cam.combined,x,y,w,h);