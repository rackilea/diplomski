for(i in 1 : dates$length) { 
 #Fetching one by one date object using for each loop in R
 index = .jevalArray(dates)[[i]]
 # Holding an individual array into variable 
 print(index$toString())
 # Now printing using Java toString() method only.
 }