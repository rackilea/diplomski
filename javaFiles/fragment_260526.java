ConvertCmd cmd = new ConvertCmd();
IMOperation io = new IMOperation();
io.size(64,32);
io.addRawArgs("canvas:#00000000");
io.addImage(); //output
cmd.run(io, "out.png");