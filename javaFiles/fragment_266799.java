Combination cmb = new Combination();

cmb.generate("pppeeeople");

ArrayList<String> list = cmb.getCombinations();

for(String str : list){
    System.out.println(str);
}