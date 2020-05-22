@NamedEntityGraph(
    name = "Graph.Department.FetchManagers", 
    includeAllAttributes = false,
    attributeNodes = {
        @NamedAttributeNode(value = "name"),
        @NamedAttributeNode(value = "employees", subgraph = "FetchManagers.Subgraph.Managers")
    },
    subgraphs = {
        @NamedSubgraph(
            name = "FetchManagers.Subgraph.Managers",
            type = Employee.class,
            attributeNodes = {
                @NamedAttributeNode(value = "name")
            }
        )
    },
    subclassSubgraphs = {
        @NamedSubgraph(
            name = "FetchManagers.Subgraph.Managers",
            type = Manager.class,
            attributeNodes = {
                @NamedAttributeNode(value = "carAllowance"),
            }
        )
    }
)