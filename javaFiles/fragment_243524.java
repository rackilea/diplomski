//get gps data
        LatLongAlt lla = getLatLonAlt();
        if (lla == null) {
            return;
        }
        //create image data holder
        dataHolder = new Data(lla, mSensor.getAzimuth(), -1 * mSensor.getPitch(), mSensor.getRoll());
        //get four corner geo locations
        GeotagActivity gT = new GeotagActivity(dataHolder.getLatLonAlt(), dataHolder.getAzimuth(), dataHolder.getPitch(), dataHolder.getRoll());
        //create four corners holder
        FourCorners fc = new FourCorners(gT.getTopLeft(), gT.getTopRight(), gT.getBottomLeft(), gT.getBottomRight());
        //set four corners
        dataHolder.setFourCorners(fc);
        setLocked(false);
        this.notify();