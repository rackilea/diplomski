// frame is input, out is output            
Scalar minValues = new Scalar(RFrom, GFrom, BFrom);
Scalar maxValues = new Scalar(RTo, GTo, BTo);
Mat mask = new Mat();
Core.inRange(frame, minValues, maxValues, mask);
frame.copyTo(out, mask);