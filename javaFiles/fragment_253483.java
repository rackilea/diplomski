for (int i = 0; i < this.fileNames.length; i++){
    String file = this.fileNames[i];
    String concatenate = path + file;
    URL url = new URL(concatenate);
    this.urls[i] = url;
    System.out.println(Arrays.toString(this.urls));
}