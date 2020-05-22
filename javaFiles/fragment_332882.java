# Original 2D array which is an array, containing arrays of ints. i.e. int[][]
x = [[1, 2, 3], [4, 5, 6];

for (a : x) {
  # at this point on the first iteration, a = [1,2,3]. i.e. int[]
  for (b : a) {
    # at this point on the first iteration, b = 1. i.e. int
  }
}