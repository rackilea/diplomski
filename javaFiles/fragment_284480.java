for(int i = 0 ; i < _wifiConnection.getListSSIDs().size(); i++){
            if(_wifiConnection.getListSSIDs().get(i).equals(ssid)){
                flag = true;
                break;
            }
        }