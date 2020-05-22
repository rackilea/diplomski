public class Utils{
 public static ArrayList<String> loadFiles(){
         File f = new File(home);
        if (f.exists()){
            String [] media = f.list();
            ArrayList<String> files = new ArrayList<>();
            for (int i=0; i<media.length;i++){
                if (media[i].endsWith(".jpg")||
                        media[i].endsWith(".png")||
                        media[i].endsWith(".JPEG")||
                        media[i].endsWith(".3gp")||
                        media[i].endsWith(".mp4")||
                        media[i].endsWith(".mov")){
                    files.add(media[i]);
                }
            }
            return files;
        }
    }
}