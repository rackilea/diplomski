ArrayList<String> cmd = new ArrayList<String>();
cmd.add(imgkPath+"convert");

for (int i=0, l=pdfs.length; i<l; i++){
    cmd.add(pdfs[i]);
}
cmd.add(outputPath+outName);

imgkProcess = Runtime.getRuntime().exec(cmd.toArray(new String[cmd.size()]));