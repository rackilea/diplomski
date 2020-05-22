String process = 'uname -a | awk {print\$2}'

// Split the string into sections based on |
// And pipe the results together
Process result = process.tokenize( '|' ).inject( null ) { p, c ->
  if( p )
    p | c.execute()
  else
    c.execute()
}
// Print out the output and error streams
result.waitForProcessOutput( System.out, System.out )