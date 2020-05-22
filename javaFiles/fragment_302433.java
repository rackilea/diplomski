java -cp .:antlr-3.2.jar Main "set value1 10001"
line 0:-1 rule integer1 failed predicate: {Integer.parseInt($Int.text) >= 1 && Integer.parseInt($Int.text) <= 10000}?
Value1 :: null

java -cp .:antlr-3.2.jar Main "set value2 30000"
line 0:-1 rule integer2 failed predicate: {Integer.parseInt($Int.text) >= 0 && Integer.parseInt($Int.text) <= 25999}?
Value2 :: null

java -cp .:antlr-3.2.jar Main "set value1 0"
line 0:-1 rule integer1 failed predicate: {Integer.parseInt($Int.text) >= 1 && Integer.parseInt($Int.text) <= 10000}?
Value1 :: null