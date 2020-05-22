public  boolean SetFileList(String directory){
    list = new ArrayList<>();

    if(DirectoryExist(directory)) { //DirectoryExist() verify if the parameter directory it's a true directory

        File[] files = new File(Environment.getExternalStorageDirectory() +"/"+directory).listFiles();

        if (files == null) {
            return false;
        }

        else if (files.length == 0) {
            return false;
        }

        else {
            Arrays.sort(files, new Comparator<File>() {
                @Override
                public int compare(File file, File t1) {
                    int n1 = extractNumber(file.getName());
                    int n2 = extractNumber(t1.getName());
                    return n1 - n2;
                }
                private int extractNumber(String name) {
                    int i = 0;
                    try {
                        int s = name.indexOf(' ')+1;
                        int e = name.lastIndexOf('.');
                        String number = name.substring(s, e);
                        i = Integer.parseInt(number);
                    } catch(Exception e) {
                        i = 0; // if filename does not match the format
                        // then default to 0
                    }
                    return i;
                }
            }); //<------this method is supposed to sort

            for (File file : files) {
                list.add(file.getName());
                System.out.println(file.getName());
            }

            return true;
        }
    }

    else{
        return false;
    }
}