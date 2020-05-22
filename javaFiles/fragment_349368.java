try {
            _logger.log(Level.FINEST,"createInsecureRfcommSocket by reflection");
            fSocket = (BluetoothSocket)fDevice.getClass().getMethod("createInsecureRfcommSocket", new Class[]{Integer.TYPE}).invoke(fDevice, new Object[]{Integer.valueOf(1)});
        } catch (NoSuchMethodException e) {
            fSocket = null;
        } catch (InvocationTargetException e) {
            fSocket = null;
        } catch (IllegalAccessException e) {
            fSocket = null;
        }


        if (fSocket == null) {
            _logger.log(Level.FINEST,"Connect over createInsecureRfcommSocketToServiceRecord");
            fSocket = fDevice.createInsecureRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"));
        }