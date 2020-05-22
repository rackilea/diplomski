import petl

table = petl.fromxlsx('samplefile.xlsx') #File path, in this case right next to my script
largest_column = 0
for row in petl.data(table):
    for counter, value in enumerate(row):
        if value is not None and counter > largest_column:
            largest_column = counter
print "The largest Column found with data was {0}".format(largest_column + 1)