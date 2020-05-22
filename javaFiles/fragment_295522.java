public static void main(String[] args) {
    String pad = "C:\\Users\\Bernard\\Documents\\Paradox Interactive";
    File bestand = new File(pad + "\\test.mod");
    BufferedWriter pen = null;
    try {
        pen = new BufferedWriter(new FileWriter(bestand));
        pen.write("line1");
        pen.write("line2");
        pen.flush();
    }catch(IOException e){
        // Probably should have some treatment here too
    }
    finally {
        if (pen != null) {
            pen.close();
        }
    }
}