File file = new File("C:\\abc\\def\\ghi"); //def, ghi doesnot exists
file.mkdirs();
try {
    file.createNewFile(); //throw IOE
    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file)));
       //some logic
} catch (IOE ioe) {
       // handleException
}