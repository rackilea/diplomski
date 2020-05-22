StatelessKnowledgeSession ksession = this.kbase.newStatelessKnowledgeSession();

    KnowledgeRuntimeLogger klogger = configureKnowledgeRuntimeLogger(ksession);

    List<Command> commands = new ArrayList<Command>();
    commands.add(CommandFactory.newInsert(inputObj, "inputObj"));
    commands.add(CommandFactory.newFireAllRules());
    commands.add(CommandFactory.newQuery("outputObj", "GetOutputObj"));

    ExecutionResults results = ksession.execute(CommandFactory.newBatchExecution(commands));

    QueryResults queryResults = ((NativeQueryResults)results.getValue("baseTrade")).getResults();

    try
    {
        Iterator iter = queryResults.iterator();
        while(iter.hasNext())
        {
            QueryResult result = iter.next();

            //There can be only one... just like Highlander
            //Could switch this up and return a list, but we only expect one thing from here.
            return (BaseTrade) result.get("baseTrade");
        }
    }
    finally
    {
        if(klogger != null)
        {
            klogger.close();
        }
    }