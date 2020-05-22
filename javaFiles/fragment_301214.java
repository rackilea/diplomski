if (work < max) {
   work left = split left half
   work right = split right half
   fork (left) 
   right.compute()
   left.join()
}