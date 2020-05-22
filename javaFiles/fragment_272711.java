// this is my pseudocode - haven't been doing groovy and java for long time
java.util.Map paramMap = new java.util.HashMap() // copy params here

foreach(p in params)
{
  paramMap.put(p.Key, p.Value)
}

java.util.Map nextUrl = new java.util.HashMap()

nextUrl.put("controller", controllerName)
nextUrl.put("action", actionName)
nextUrl.put("params", paraMap) // <- note paramMap, not params!

session.setAttribute("nextUrl", nextUrl)