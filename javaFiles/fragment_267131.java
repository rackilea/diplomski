// Returns true if the actor is currently processing a message.
// It will always return false for remote actors.
// Method is exposed to subclasses to be able to implement custom
// routers based on mailbox and actor internal state.
protected def isProcessingMessage(a: ActorRef): Boolean = a match {
  case x: LocalActorRef ?
    val cell = x.underlying
    cell.mailbox.isScheduled && cell.currentMessage != null
  case _ ? false
}

// Returns true if the actor currently has any pending messages
// in the mailbox, i.e. the mailbox is not empty.
// It will always return false for remote actors.
// Method is exposed to subclasses to be able to implement custom
// routers based on mailbox and actor internal state.
protected def hasMessages(a: ActorRef): Boolean = a match {
  case x: LocalActorRef ? x.underlying.mailbox.hasMessages
  case _                ? false
}