height = 15; 
width = 15;

var cmds = //cmds is a shortage of commands
[
     "open=[C:\\Users\\Documents\\Ru\\simulations_Ru\\Batch1_sc\\1 Atoms\\15x15_stem_image00001_total_df_00001.bin] image=[64-bit Real] width=15 height=15 offset=0 number=1 gap=0",
     "another command",
     "and so on..."
];

for(var i in cmds)
{
  IJ.run("Raw...", cmds[i]);


  imp = IJ.getImage();
  imp.setRoi(0, 0, width, height);
  IJ.run(imp, "Measure", "");

  imp.close();
}