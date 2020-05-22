@Override
public void onConfigurationChanged(Configuration newConfig)
{
    if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
    {
        scene.setScale(1);
    }
    else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
    {
        scene.setScaleX(480.0f / 720.0f);
        scene.setScaleY(1.0f);
    }

            //Rebuilds the scene. onLoadScene() calls to this method.
    BuildScene();

}