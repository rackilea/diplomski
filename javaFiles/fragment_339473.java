do {
  if (... keys are equal or can be compared ...) {
    // Go left, right or return the current node
    ...
  } else if ((q = pr.find(h, k, kc)) != null)
    // Search the right subtree recursively
    return q;
  else
   // Go to the left subtree
   p = pl;
} while (p != null);