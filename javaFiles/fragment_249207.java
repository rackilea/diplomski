public static void ComputeAndExecuteBestMove()
    {
        // since Player begins, we minimize the gain value for the first move
        if ((MaxDepth-Depth) % 2 == 0) 
        {
            min(Depth);
            Field[bestCol,bestRow] = Player;
        }
        else 
        {
            max(Depth);
            Field[bestCol,bestRow] = Computer;
        }

        // next move
        Depth--;
    }