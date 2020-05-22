String s = "[SSID: Stephen Joseph, BSSID: ##:a6:##:c0:21:##, capabilities: [WPA2-PSK-CCMP][WPS][ESS], level: -78, frequency: 2442, timestamp: 998653673499, hs2Info: <none>, distance: ?(cm), distanceSd: ?(cm), SSID: TP-LINK_G6D356, BSSID: 30:b5:c2:f5:$$:56, capabilities: [WPA-PSK-CCMP][WPA2-PSK-CCMP][WPS][ESS], level: -86, frequency: 2452, timestamp: !!!653673417, hs2Info: <none>, distance: ?(cm), distanceSd: ?(cm), SSID: cbtap998852211C:CF:7F:0A:AC:33, BSSID: 5e:cf:7f:0a:ac:91, capabilities: [ESS], level: -46, frequency: 2412, timestamp: 238653673402, hs2Info: <none>, distance: ?(cm), distanceSd: ?(cm), SSID: Tech_D0008214, BSSID: 70:5a:9e:65:30:56, capabilities: [WPA-PSK-CCMP+TKIP][WPA2-PSK-CCMP+TKIP][ESS], level: -88, frequency: 2462, timestamp: 238653673422, hs2Info: <none>, distance: ?(cm), distanceSd: ?(cm), SSID: Tech_D0018138, BSSID: 50:09:59:83:ee:05, capabilities: [WPA-PSK-CCMP+TKIP][WPA2-PSK-CCMP+TKIP][ESS], level: -91, frequency: 2437, timestamp: 238653673427, hs2Info: <none>, distance: ?(cm), distanceSd: ?(cm)]";
     int idx = s.indexOf("cbtap"); // cbtap998852211C:CF:7F:0A:AC:33,
     if (idx != -1)
     {
        int idx2 = s.indexOf(',',idx);
        s = s.substring(idx,idx2);
        String cbtap = s.substring(0,5);
        idx = s.indexOf(':');
        String id = s.substring(5,idx-2);
        String ip = s.substring(idx-2);
        System.out.println(cbtap+" / "+id+" / "+ip);
     }