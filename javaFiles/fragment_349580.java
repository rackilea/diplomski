float width = 20; // 20 meters
//You can calculate on your chosen width or height to maintain aspect ratio
float height = (Gdx.graphics.getHeight() / Gdx.graphics.getWidth()) * width;        
camera = new OrthographicCamera(width, height);
//Now the center of the camera is on 0,0 in the game world. It's often more desired and practical to have it's bottom left corner start out on 0,0
//All we need to do is translate it by half it's width and height since that is the offset from it's center point (and that is currently set to 0,0.
camera.translate(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
camera.update();