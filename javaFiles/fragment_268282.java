@Rule(
  key = "avoidSocketsApi",
  name = "The \"Sockets\" API should not be used",
  description = "...",
  priority = Priority.CRITICAL,
  tags = {"bug"})
public class AvoidSocketsApiRule extends IssuableSubscriptionVisitor {