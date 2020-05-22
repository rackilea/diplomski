PowerManager powerManager = (PowerManager) this.getSystemService(Context.POWER_SERVICE);        
    //NEED ROOT PERMISSION :( permission nedded: android.permission.DEVICE_POWER (only system app)
    Class c;
    try {
        c = Class.forName("android.os.PowerManager");
        Method[] ar = c.getDeclaredMethods();
        for (Method m : ar) {
            Log.d("test", "we have: "+m.getName());
            if (m.getName().equalsIgnoreCase("setPowerSaveMode")) {
                Boolean response = (Boolean) m.invoke(powerManager, true);
                Log.d("test", "invoked?: " + response);
            }
        }
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    } catch (InvocationTargetException e) {
        e.printStackTrace();
    }