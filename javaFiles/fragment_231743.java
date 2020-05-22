class VolatileDoubleArray(val length : Int){
  val array = new Array[Double](length);
  @volatile var marker = 0;
  def apply(i : Int) = {marker; array(i); }
  def update(i : Int, x : Double) { array(i) = x; marker = 0; }
}