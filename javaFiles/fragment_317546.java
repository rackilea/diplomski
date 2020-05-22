private static void Main()
{
    var numTimesToExecute = 3;

    ExecuteNTimes(numTimesToExecute, Method_1);
    ExecuteNTimes(numTimesToExecute, Method_2);
    ExecuteNTimes(numTimesToExecute, Method_3);
    ExecuteNTimes(numTimesToExecute, Method_4);

    Console.Write("\nPress any key to exit...");
    Console.ReadKey();
}