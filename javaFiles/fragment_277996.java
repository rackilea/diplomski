case class SearchBooks(title:String)
case class Book(id:Long, title:String)

class BookSearcher extends Actor{

  def receive = {
    case req:SearchBooks =>
      val routees:List[ActorRef] = ...//Lookup routees here
      implicit val timeout = Timeout(10 seconds)
      implicit val ec = context.system.dispatcher

      val futures = routees.map(routee => (routee ? req).mapTo[List[Book]])
      val fut = Future.sequence(futures)

      val caller = sender //Important to not close over sender
      fut onComplete{
        case Success(books) => caller ! books.flatten

        case Failure(ex) => caller ! Status.Failure(ex)
      }
  }
}