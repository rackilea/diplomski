SolrCore core = coreContainer.create("newcore", coreProps)
coreContainer.swap("newcore", "livecore")

// the old livecore is now newcore, so unload it and remove all the related dirs
SolrCore oldCore = coreContainer.getCore("newCore")
while (oldCore.getOpenCount > 1) {
  oldCore.close()
}
coreContainer.unload("newcore", true, true, true)