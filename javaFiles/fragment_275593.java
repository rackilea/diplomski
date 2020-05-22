}
        catch(Exception e)
        {
            Log.v("Receiving Error: ",e.toString());
        }
        finally
        {
            socket.close();
        }
    }
    public DeviceDetails getDeviceFromString(String str)
    {
        String type;
        String IP;
            type=str.substring(0,str.indexOf('`'));
            str = str.substring(str.indexOf('`')+1);
            IP=str;
        DeviceDetails device = new DeviceDetails(type,IP);
        return device;
    }
}