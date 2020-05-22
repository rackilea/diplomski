filenamePrefix = "hello_"
filenamePostfix = ".xml"

letters = "abc...xyz"

for letter in letters
   upper = Uppercase(letter)
   sqlquery = "SELECT * FROM people WHERE column LIKE '" + letter + "%' 
                                       OR column LIKE '" + upper  + "%' ;"
   results = runquery( sqlquery )
   filename = filenamePrefix + letter + filenamePostfix
   saveToFile( filename , results )

sqlquery = "SELECT * FROM people
            WHERE NOT REGEXP_LIKE(column, '^[[:alpha:]]', 'i') ;" 
                    /* 'i' stands for case Insensitive */ 
results = runquery( sqlquery )
filename = filenamePrefix + "spec" + filenamePostfix
saveToFile( filename , results )