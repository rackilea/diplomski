void loop()
{
    if (button || tilt)
    {
        bool isGpsLocationValid = false;
        while (!isGpsLocationValid)
            {
                while(ss.available()<=0)
                {
                    Thread.sleep(1000); // wait for 1 sec
                }
                char c = byte(ss.read());
                if (gps.encode(c)) 
                {    
                    if (gps.location.isValid())  
                    {
                        Serial.print(gps.location.lat(), 6); 
                        Serial.print(gps.location.lng(), 6); 

                        isGpsLocationValid = true;
                    }
                }   
             }

    }
}