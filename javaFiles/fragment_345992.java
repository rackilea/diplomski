public static final String TIME_SERVER = "time-a.nist.gov";

public static void printTimes() throws IOException {
            NTPUDPClient timeClient = new NTPUDPClient();
            InetAddress inetAddress = InetAddress.getByName(TIME_SERVER);
            TimeInfo timeInfo = timeClient.getTime(inetAddress);
            //long returnTime = timeInfo.getReturnTime();   //local device time
            long returnTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();   //server time

            Date time = new Date(returnTime);
            Log.e("getCurrentNetworkTime", "Time from " + TIME_SERVER + ": " + time);

            Log.e("Local time", "Local time");
            Log.e("Local time", "Current time: " + new Date(System.currentTimeMillis()));
            Log.e("Local time", "Time info: " + new Date(timeInfo.getReturnTime()));
            Log.e("Local time", "GetOriginateTimeStamp: " + new Date(timeInfo.getMessage().getOriginateTimeStamp().getTime()));

            Log.e("NTP time", "Time from " + TIME_SERVER + ": " + time);

            Log.e("Local time", "Time info: " + new Date(timeInfo.getMessage().getReceiveTimeStamp().getTime()));
            Log.e("Local time", "GetOriginateTimeStamp: " + new Date(timeInfo.getMessage().getTransmitTimeStamp().getTime()));

        }