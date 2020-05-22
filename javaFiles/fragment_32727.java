Given text query =
"""
{
  element(name:"<argument1>") {
    name
  }
}
"""
And replace query.argument1 = argument1
And request {query: '#(query)'}
When method post
Then status 200