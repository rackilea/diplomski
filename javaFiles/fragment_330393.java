@Override
public boolean onTouchEvent(MotionEvent event) {

    if(world != null && me != null && canvas_width != -1 && canvas_height != -1) {
        Camera camera = Camera.getInstance();
        float x = camera.getX() <= 0 ? event.getX() - me.x*camera.getScale() : camera.getX() >= world.WIDTH - canvas_width ? ((world.WIDTH - canvas_width) + event.getX()) - me.x*camera.getScale() : event.getX() - canvas_width/2;
        float y = camera.getY() <= 0 ? event.getY() - me.y*camera.getScale() : camera.getY() >= world.HEIGHT - canvas_height ? ((world.HEIGHT - canvas_height) + event.getY()) - me.y*camera.getScale() : event.getY() - canvas_height/2;

        if (client != null && client.isConnected()) {
            JSONObject json = new TouchEventObject(x, y).toJSON();
            client.sendMessage(PacketType.MOUSEMOVE, json);
            try {
                Thread.sleep(100);
            } catch(Exception e) {}
        }
    }

    return true;
}