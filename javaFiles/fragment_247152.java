trait EmailEnumConvertible[A]{
  def toEmailEnum(value: A): Option[EmailEnum]
}

object EmailEnumConvertible{
  implicit val tradeToEmailEnum: EmailEnumConvertible[TradeEnum] = new EmailEnumConvertible[TradeEnum]{
    private val map = Map(
      TradeEnum.CLEARED -> EmailEnum.T_CLEARED,
      TradeEnum.CONFIRMED -> EmailEnum.T_CONFIRMED
    )
    override def toEmailEnum(value: TradeEnum): Option[EmailEnum] = map.get(value)
  }

}

object AnyOtherName{
  implicit class EmailEnumOps[A] (value: A){
    def toEmail()(implicit emailConvertable:EmailEnumConvertible[A]): Option[EmailEnum]={
      emailConvertable.toEmailEnum(value)
    }
  }
}

import AnyOtherName._

object MultipleToSingleEnum {
  def main(args: Array[String]): Unit = {
    println (TradeEnum.CLEARED.toEmail) // No error :-)
  }
}