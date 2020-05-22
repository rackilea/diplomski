@Override
public boolean touchDown(int x, int y, int pointer, int button){

    camera.unproject(touch.set(x, y, 0)); //<---

    //use touch.x and touch.y as your new touch point

    return false;
}