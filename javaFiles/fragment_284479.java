public List<String> getListSSIDs() {
        for(int i = 0; i < scanResults.size(); i++)
        {
            _listSSIDs.add(scanResults.get(i).SSID);
        }
        return _listSSIDs;
    }