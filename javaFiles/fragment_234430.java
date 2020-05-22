for (Function functionValue : flist)
    {
        List<Function> functionList = funcMap.get(functionValue.getFunc());
        if (functionList != null && !functionList.isEmpty())
        {
            functionList.add(functionValue);
        }
        else
        {
            functionList = new ArrayList<Function>();
            functionList.add(functionValue);
            funcMap.put(functionValue.getFunc(), functionList);
        }
    }