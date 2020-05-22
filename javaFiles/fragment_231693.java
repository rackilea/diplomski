package mypack;

import java.util.*;

public class TableClass {
    /* HashMap containing your values:
       map.put("locId", [data]);
       ...
    */
    public Map<String,String> cwdMap;

    public Map<String,String> getCwdMap() {
        return cwdMap;
    }

    public void setCwdMap(Map<String,String> cwdMap) {
        this.cwdMap = cwdMap;
    }

    @Override
    public boolean equals(Object obj) {
        TableClass tClass = (TableClass) obj;

        for(String col: this.cwdMap.keyset()){
            if (! tClass.cwdMap.get(col).equals(this.cwdMap.get(col)){
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hCode = 0;
        for(String col: this.cwdMap.keyset()){
            hCode = hCode+cwdMap.get(col).hashCode();
        }

        return hCode;
    }
}