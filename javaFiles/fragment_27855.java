f <- function(x){
  # @IsmailMüller
  temp <- x+1
  test <- 2:x

  # while temp is divisible by at least one precedent value (not prime)
  while( any( (temp %% test) == 0 ) ){
    # increase the value of temp by 1
    temp <- temp+1
  }
  temp
}
f(11)