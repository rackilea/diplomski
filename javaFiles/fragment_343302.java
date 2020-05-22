object FoodTrainer {
  def main(args Array[String]): Unit = {
    val input = args(0)
    val outputDir = args(1)
    val model: FoodModel = new FoodTrainer(input).train() 
    val out = new ObjectOutputStream(new File(outputDir + "/model.bin"))
    out.writeObject(model)
  }
}