long size_of_int = (long)Math.pow(2, 32);
int number_of_wraps = 305 // Only correct in your example!
                          // You can't deduct the number of wraps from
                          // the wrong value alone, because that information
                          // is lost in the modulo (the "wrap")
long correct_number = wrong_number + size_of_int * number_of_wraps;