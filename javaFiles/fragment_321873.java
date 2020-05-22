library(rJava)
.jinit()
# note that you have to point to place where utils directory is
.jaddClassPath(dir("place_where_your_package_is",full.names=TRUE))
obj <- .jnew("utils.Rinterface")
# call method
result=.jcall(obj, returnSig="Ljava/util/Set;", method="getPhones")