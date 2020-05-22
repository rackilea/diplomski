outer for loop:
 u[i] = b[0][i]; --> u[0] = 1

 inner for loop:
 u[i] += b[j][i] --> u[0] += b[1][0] so --> u[0] = 1 + 2 --> u[0]=3

 second loop in inner for loop:

 "now j = 2"
  u[0] += b[2][0] --> u[0] = 3 + 3 --> u[0] = 6