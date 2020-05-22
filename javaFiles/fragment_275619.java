ArrayList<ArrayList<String>> totalFile = new ArrayList<ArrayList<String>>();
while(fp.next()){
        ArrayList<String> file = new ArrayList<String>();
        file.add(fp.getString(1));
        file.add(fp.getString(2));
        file.add(fp.getString(3));
        file.add(fp.getString(4));
        file.add(fp.getString(5));
        file.add(fp.getString(6));

        totalFile.add(file);
        System.out.println(totalFile);
}