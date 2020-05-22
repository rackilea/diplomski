MulticastDNSService mDNSService = null;
Browse browse = null;
Object serviceDiscoveryInstance = null;

public void stop() {
    try {
        if (serviceDiscoveryInstance != null && mDNSService != null) {
            mDNSService.stopServiceDiscovery(serviceDiscoveryInstance);
            mDNSService.close();
        }

        serviceDiscoveryInstance = null;
        //mDNSService = null;
        if (browse != null) {
            browse.close();
            // this is required, otherwise the listeners won't get called in next run
            browse = null;
        }

        Querier querier = MulticastDNSLookupBase.getDefaultQuerier();
        if (querier != null) {
            querier.close();
        }
        MulticastDNSLookupBase.setDefaultQuerier(null);
    } catch (Exception e) {
        Log(..)
    }
}

public void start() {
    try {
        Querier querier = MulticastDNSLookupBase.getDefaultQuerier();
        if (querier != null) {
            if (mDNSService == null) {
                mDNSService = new MulticastDNSService();
            }

            if (browse == null) {
                browse = new Browse(SERVICE_TYPE);
            }

            if (serviceDiscoveryInstance == null) {
                serviceDiscoveryInstance = mDNSService.startServiceDiscovery(browse, this);
            }

            // add existing entries
            Lookup resolve = new Lookup(SERVICE_TYPE);
            resolve.setQuerier(mDNSService.getQuerier());
            ServiceInstance[] services = resolve.lookupServices();
            for (ServiceInstance service : services) {
                addDevice(service);
            }
            resolve.close();
        } else {
            Log.e("Cannot start mDNS-discovery because querier is not set up!");
            resetDiscovery();
        }
    } catch (Exception e) {
        Log.e("Error while discovering network.", e);
        resetDiscovery();
    }
}

public void clearCaches() {
    if (MulticastDNSCache.DEFAULT_MDNS_CACHE != null) {
        MulticastDNSCache.DEFAULT_MDNS_CACHE.clearCache();
    }
    mDNSService = null;
    browse = null;
}

private void resetDiscovery(){
    stop();
    mDNSService = null;
    browse = null;
}