protected void runScoped(Runnable function)
{
    scenarioScope.enter();

    try {
        function.run();
    }
    finally {
        scenarioScope.exit();
    }
}