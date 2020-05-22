public List<Integer> getCells(File file){
    List<Integer> list = new ArrayList<>();
    try {    
        Scanner getCells = new Scanner(file);
        while (getCells.hasNextInt()){
            list.add(Integer.valueOf(getCells.nextInt()));

        }
        getCells.close();
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } finally {
          return list;
    }
}