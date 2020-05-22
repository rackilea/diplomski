// Short signature
//             v------------------- "We must be able to find a Comparator for A"
def ordered[A: java.util.Comparator](a0: A, a1: A, a2: A) = {
  val cmp = implicitly[java.util.Comparator[A]]   // This is the Comparator
  cmp.compare(a0, a1) <= 0 && cmp.compare(a1, a2) <= 0
}

// Long signature version
def ordered[A](a0: A, a1: A, a2: A)(implicit cmp: java.util.Comparator[A]) = {
  cmp.compare(a0, a1) <= 0 && cmp.compare(a1, a2) <= 0
}