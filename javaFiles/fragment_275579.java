@SuppressWarnings("deprecation")
@Override
public void dispose()
{
    ComponentPeer peer = getPeer();

    super.dispose();

    if (null != peer)
    {
        try
        {
            Class<?> peerClass = Class.forName("sun.lwawt.LWComponentPeer");

            Field targetField = peerClass.getDeclaredField("target");
            targetField.setAccessible(true);
            targetField.set(peer, null);

            Field windowField = peer.getClass().getDeclaredField("platformWindow");
            windowField.setAccessible(true);
            Object platformWindow = windowField.get(peer);

            targetField = platformWindow.getClass().getDeclaredField("target");
            targetField.setAccessible(true);
            targetField.set(platformWindow, null);

            Field componentField = peerClass.getDeclaredField("platformComponent");
            componentField.setAccessible(true);
            Object platformComponent = componentField.get(peer);

            targetField = platformComponent.getClass().getDeclaredField("target");
            targetField.setAccessible(true);
            targetField.set(platformComponent, null);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}