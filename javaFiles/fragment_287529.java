private ArrayList<String> extStorageLoc(){
        String[] toSearch = readFile("/etc/vold.fstab").split(" ");
        ArrayList<String> out = new ArrayList<String>();
        for(int i = 0; i < toSearch.length; i++){
            if(toSearch[i].contains("dev_mount")){
                if(new File(toSearch[i+2]).exists()){
                    out.add(toSearch[i+2]);
                }
            }
        }
        return out;
}