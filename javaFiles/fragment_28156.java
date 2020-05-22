* 1st method call

list.size() == 0

for 1 to 0 {
    (00 >> 1 = 00) & 01 == 0
    (00 >> 0 = 00) & 01 == 0
}

list.add("00")

* 2nd method call

list.size() == 1

for 1 to 0 {
    (01 >> 1 = 00) & 01 == 0
    (01 >> 0 = 01) & 01 == 1
}

list.add("01")

* 3rd method call

list.size() == 2

for 1 to 0 {
    (10 >> 1 = 01) & 01 == 1
    (10 >> 0 = 10) & 01 == 0
}

list.add("10")

* 4th method call

list.size() == 3

for 1 to 0 {
    (11 >> 1 = 01) & 01 == 1
    (11 >> 0 = 11) & 01 == 1
}

list.add("11")

* 5th method call

list.size() == 4 == 2 ^ 2

print the list