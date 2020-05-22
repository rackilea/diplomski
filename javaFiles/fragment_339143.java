while (inStream.available() == 0)
            {
                ////this part is not working
                Log.v("DEV", "sleep "+inStream.available());
                android.os.SystemClock.sleep(100);
            }
            Log.v("DEV", "NoSleep "+inStream.available());