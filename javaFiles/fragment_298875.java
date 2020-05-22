public static void main(String[] args) {
    GUI win = new GUI(null);
    if(args.length==2) {
        win = new GUI(null);
        StringBuilder params = new StringBuilder();
        for(String s : args) {
            params.append(s);
            params.append("\n");
        }
        JOptionPane.showMessageDialog(null, params);
        try {
            FileFunction.loadList(new FileInputStream(new File(args[1])));
        }
        catch(IOException ioe) {
            FileFunction.showFileError(ioe);
        }
    }