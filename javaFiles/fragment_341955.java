Field field = null;
try {
    field = SignalStrength.class.getDeclaredField("mLteRssnr");
    if (field.getType().isAssignableFrom(int.class)) {
        field.setAccessible(true);
        int lteRssnr = (int) field.get(signalStrength); // pass the instance of SignalStrength here.

    }
} catch (NoSuchFieldException e) {
    e.printStackTrace();
}