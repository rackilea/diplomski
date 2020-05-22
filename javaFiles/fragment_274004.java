try{
            List<String> envList = new ArrayList<String>();
            Map<String, String> envMap = System.getenv();

            for (String envName : envMap.keySet()) {
                envList.add(envName + "=" + envMap.get(envName));
            }

            final String[] environment = (String[]) envList.toArray(new String[0]);

            String command= "reboot";
            Runtime.getRuntime().exec(
                    new String[]{"su", "-c", command},
                    environment).waitFor();
}catch(IOException e){
//catch exception
}