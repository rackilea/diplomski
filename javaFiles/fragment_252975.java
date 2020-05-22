DataInput data = new DataInput();
data.save();// <--
int sNum = data.stu();
int[] sum = data.sum();
DataOutput out = new DataOutput(sNum, sum);
out.ranker();