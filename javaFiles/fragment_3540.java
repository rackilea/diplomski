public class ChangeTickRate implements IFMLLoadingPlugin, IFMLCallHook {
    // Stored client-side tickrate (default at 20TPS)
    private Field clientTimer = null;
    @SideOnly(Side.CLIENT)
    public static void updateClientTickrate(float tickrate) {
        Minecraft mc = Minecraft.getMinecraft();
        if(mc == null) return; // Oops! Try again!
        try {
            if(clientTimer == null) {
                for(Field f : mc.getClass().getDeclaredFields()) {
                    if(f.getType() == Timer.class) {
                        clientTimer = f;
                        clientTimer.setAccessible(true);
                        break;
                    }
                }
            }
            clientTimer.set(mc, new Timer(tickrate));
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}