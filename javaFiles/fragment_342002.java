require(PostgresSQL)
 do_operation <- function()
 {
   r <- dbConnect(drv, host='localhost', port='5432',dbname='r1', user='postgres', password='pwd')\",silent=TRUE)
   rs <-dbSendQuery(r,\"select colmn1 from host_brnd345633456_table1 limit 10
   ftch <- ftch(rs,n=-1)
   res <- median(ftch$colmn1)
   return(res)
 }