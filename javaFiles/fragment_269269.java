public Map<String,String> states(){
        String state = @"SOME_STATE";
        switch (this.state) {
            case 1:
                state = "STATE1";
                break;
            case 2:
                state = "STATE2";
                break;
            case 3:
                state = "STATE3";
                break;
            case 4:
                state = "STATE4";
                break;
            case 5:
                state = "STATE5";
                break;
            case 6:
                state = "STATE6";
                break;
            case -1:
                state = "STATE-1";
                break;
        }
        Map<String,String> map = new HashMap<String, String>();
        map.put("state", state);
        return map;