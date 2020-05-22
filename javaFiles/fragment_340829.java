private static String getConnectionString()
{
    String connectionString = null;
    // Wifi is the preferred transmission method
    f(WLANInfo.getWLANState() == WLANInfo.WLAN_STATE_CONNECTED)
    {
        connectionString = ";interface=wifi";
    }
    // Is the carrier network the only way to connect?
    else if((CoverageInfo.getCoverageStatus() & CoverageInfo.COVERAGE_DIRECT) == CoverageInfo.COVERAGE_DIRECT)
    {
        String carrierUid = getCarrierBIBSUid();
        if(carrierUid == null)
        {
            // Has carrier coverage, but not BIBS.  So use the carrier's TCP network
            connectionString = ";deviceside=true";
        }
        else
        {
            // otherwise, use the Uid to construct a valid carrier BIBS request
            connectionString = ";deviceside=false;connectionUID="+carrierUid + ";ConnectionType=mds-public";
        }
    }
    // Check for an BIS connection
    else  if (TransportInfo.isTransportTypeAvailable(TransportInfo.TRANSPORT_BIS_B) && TransportInfo.hasSufficientCoverage(TransportInfo.TRANSPORT_BIS_B)) {
        connectionString = ";deviceside=false;ConnectionType=mds-public";
    }
    // Check for an MDS connection instead (BlackBerry Enterprise Server)
    else if((CoverageInfo.getCoverageStatus() & CoverageInfo.COVERAGE_MDS) == CoverageInfo.COVERAGE_MDS)
    {
        connectionString = ";deviceside=false";
    }
    // If there is no connection available abort to avoid bugging the user unnecssarily.
    else if(CoverageInfo.getCoverageStatus() == CoverageInfo.COVERAGE_NONE)
    {
        //no connection available
    }
    // In theory, all bases are covered so this shouldn't be reachable.
    else
    {
        connectionString = ";deviceside=true";
    }
    return connectionString;
}

/**
* Looks through the phone's service book for a carrier provided BIBS network
* @return The uid used to connect to that network.
*/
private static String getCarrierBIBSUid()
{
    ServiceRecord[] records = ServiceBook.getSB().getRecords();
    int currentRecord;
    for(currentRecord = 0; currentRecord < records.length; currentRecord++) 
    {             
        if(records[currentRecord].getCid().toLowerCase().equals("ippp")) 
        {                  
            if(records[currentRecord].getName().toLowerCase().indexOf("bibs") >= 0)
            {
                return records[currentRecord].getUid();
            }
        }
    }
    return null;
}