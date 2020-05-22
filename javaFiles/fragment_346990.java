// assuming a String name like "fred" or "barney", i.e. without "/"
final Option<ActorRef> child = child(name);
if (child.isDefined())
  return child.get();
else
  return getContext().actorOf(..., name);