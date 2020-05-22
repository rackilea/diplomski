//random is instance of java's Random class, and numberOfRows is total number of rows in the table
long rowIndex = random.nextLong()%numberOfRows;

TypedQuery typedQuery = ...;
typedQuery.setFirstResult(rowIndex);
typedQuery.setMaxResults(1);