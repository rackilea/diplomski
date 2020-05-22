long s = 1;
        for (long i = 1; i < 32; i++)
        {
            s = 1;
            long powVal = (long)Math.Pow(4, i);

            Trace.TraceInformation("powVal: " + powVal);

            for (int n = 2; n < powVal; n++)
            {
                // Each call to streak could entail 1000 operations
                s *= 1000;
                Trace.TraceInformation("s: " + s.ToString());
            }
        }