val regex = ".*/(\\d{4}-\\d{2}-\\d{2}).txt".r //remove / after .* if you think its not needed.

str match {
  case regex(date) => Some(date)
  case _ => None
}