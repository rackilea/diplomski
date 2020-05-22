arraysObject = .jnew("java/util/Arrays")

#Just taken a reference of an object of java Arrays classes
for (i in 1:length(indexes[[1]])){      
        print(arraysObject$toString(indexes[[1]][i]))       
#calling Arrays.toString() method of java into R programming
    }