//data.add(new Object[files.length][this.titles.length]);
data.add(new Object[files.length]); // can only be one dimensional

 and 

((Object[])data.get(i))[0] = tmp.getAbsolutePath();