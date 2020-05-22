assert testFunction(["null", "0", "0"]) == [1, '1.1', '1.2']
assert testFunction(["null", "0", "1", "2", "null", "4", "5", "6", "null", "8", "9"]) == [1, '1.1', '1.1.1', 'a', 2, '2.1', '2.1.1', 'a', 3, '3.1', '3.1.1']
assert testFunction(["null", "null", "null"]) == [1, 2, 3]
assert testFunction(["null", "null", "1"]) == [1, 2, '2.1']
assert testFunction(["null", "0", "1"]) == [1, '1.1', '1.1.1']
assert testFunction(["null", "0", "null"]) == [1, '1.1', 2]
assert testFunction(["null", "0", "0", "2", "2", "null"]) == [1, '1.1', '1.2', '1.2.1', '1.2.2', 2]
assert testFunction(["null", "0", "1", "2", "2", "2", "2"]) == [1, '1.1', '1.1.1', 'a', 'b', 'c', 'd']
assert testFunction(["null", "0", "1", "2", "2", "1", "0"]) == [1, '1.1', '1.1.1', 'a', 'b', '1.1.2', '1.2']
assert testFunction(["null", "0", "1", "2", "null", "4", "5", "6", "null", "8", "9"]) == [1, '1.1', '1.1.1', 'a', 2, '2.1', '2.1.1', 'a', 3, '3.1', '3.1.1']

def testFunction(array) {
    def count = 1
    def subcount = 1
    char subcountA = 'a'
    def newArray = []
    def value = []

    array.each {
        if (it.isInteger()) {
            value += it as Integer
        }
    }

    def max = value.max()
    if(!max) max = 0

    for(def j = 0 ; j <= max ; j++ ) {
        count = 1
        subcount = 1
        subcountA = 'a'

        for (def i = 0; i < array.size(); i++) {
            def curr_value = array[i]

            if (curr_value == "null") {
                newArray[i] = count
                count++
            }

            if(curr_value == j.toString()) {
                newArray[i] = newArray[j] + "." + subcount
                subcount++

                if(newArray[i].length() > 5) {
                    newArray[i] = subcountA
                    subcountA++
                }
            }
        }
    }

    print(array)
    print(" - ")
    println(newArray)
    return newArray
}