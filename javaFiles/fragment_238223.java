public static void main(String ...args){
        String agf = "abc*pqr*gas$sfd*ghn$atr*mnb$tre*fgt";
        String [] split = agf.split("\\$");
        Map<String,String> map = new HashMap<String,String>();
        for(String temp : split){
            String [] tempo = temp.split("\\*");
            StringJoiner sj = new StringJoiner(",");
            for(int i = 1; i < tempo.length;i++){
                sj.add(tempo[i]);
            }
            String value = sj.toString();
            map.put(tempo[0],value);
        }
        for(String mapkeys : map.keySet()){
            System.out.println(mapkeys+" ::: "+map.get(mapkeys));
        }
    }