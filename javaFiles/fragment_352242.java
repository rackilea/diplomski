// in packages1.scala file in local directory
package my {
  package states {
    sealed trait State
    case class CheckingOut(shoppingCartId: Long) extends State
    case class ConfirmedOrder(orderId: Long) extends State
    case class ItemShipped(orderId: Long, itemId: Long, quantity: Int) extends State
  }
}