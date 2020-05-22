require('rjson')
main <- function (){

  returnStringValue <- "ignore"
  returnJsonObject <- toJSON(returnStringValue)

  return (returnJsonObject)
}