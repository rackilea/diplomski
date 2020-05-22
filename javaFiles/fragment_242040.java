public void SaveNote(String sFileName, String sBody){
    try {
        File root = new File(this.path);
        if (!root.exists()) {
            root.mkdirs();
        }
        File file = new File(root, sFileName);

        if(!file.exists()){ //Check if file exist 
            // Create new File
            file.createNewFile();
        }

        FileWriter writer = new FileWriter(file);
        writer.append(sBody);
        writer.flush();
        writer.close();
        Toast.makeText(this.context, "Saved", Toast.LENGTH_SHORT).show();
    } catch(IOException e){
        e.printStackTrace();
    }
}