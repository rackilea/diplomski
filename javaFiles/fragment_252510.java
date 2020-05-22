//The new midpoint needs the old stepwith to calculate correctly
Complex newmidpoint = new Complex(upleft.getReal()+x*stepwidth, upleft.getImg()-y*stepwidth);

//zooming in
double distwidth = downright.getReal()-upleft.getReal();
double distheight = upleft.getImg()-downright.getImg();
double newreal = upleft.getReal()+(1/scale)*distwidth;
double newimg = upleft.getImg()-(1/scale)*distheight;
downright=new Complex(newreal, newimg);
stepwidth=(downright.getReal()-upleft.getReal())/width;

//the old midpoint is actually the already zoomed in midpoint, it needs the new stepwidth
Complex oldmidpoint = new Complex(upleft.getReal()+width/2.0*stepwidth,upleft.getImg()-height/2.0*stepwidth);
Complex diffmidpoint = newmidpoint.subtract(oldmidpoint);

upleft=new Complex(upleft.getReal()+diffmidpoint.getReal(),upleft.getImg()+diffmidpoint.getImg());
downright=new Complex(downright.getReal()+diffmidpoint.getReal(), downright.getImg()+diffmidpoint.getImg());
calc(lastrep);