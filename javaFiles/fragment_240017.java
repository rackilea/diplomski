graph = TinkerGraph.open()
names = ["LV",
         "A_C","A_T","A_V",
         "B_C","B_T","B_V",
         "C_C","C_T","C_V"]

vertices = names.collectEntries { def name ->
  [name, graph.addVertex("name", name)]
}

vertices["LV"].addEdge("link", vertices["A_C"])
vertices["LV"].addEdge("link", vertices["B_C"])
vertices["LV"].addEdge("link", vertices["C_C"])
vertices["A_C"].addEdge("link", vertices["A_T"])
vertices["A_C"].addEdge("link", vertices["A_V"])
vertices["B_C"].addEdge("link", vertices["B_T"])
vertices["B_C"].addEdge("link", vertices["B_V"])
vertices["C_C"].addEdge("link", vertices["C_T"])
vertices["C_C"].addEdge("link", vertices["C_V"])

m = [:]
m.put(vertices["A_T"], vertices["A_V"])
m.put(vertices["B_T"], vertices["B_V"])
m.put(vertices["C_T"], vertices["C_V"])