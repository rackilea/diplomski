IMOperation op = new IMOperation();

op.resize(500, 500, '>');
op.quality(85.0); // jpeg quality (%)
op.strip(); // remove EXIF comments
op.interlace("Plane"); // progressive-mode
op.define("jpeg:dot-method=float"); // float processing (more quality, but slower)
op.addImage("my_original_pic.jpg");
op.addImage("my_resized_pic.jpg");

ConvertCmd convert = new ConvertCmd();
convert.run(op);