from collections import Counter

inp = input("Enter letters") # input() if using python 3

l = len(inp.strip()) # get length of input string ,inp.strip() removes any whitespace, just use len(inp) if you want to include

c = Counter(inp)

for char in c:
    c[char] = c[char] * 100 / l  # don't need to cast as float for python 3
print (c)
Counter({'C': 30.0, 'G': 30.0, 'A': 20.0, 'T': 20.0})