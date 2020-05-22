String query = "MATCH (n:POINT) " +
                 "  WHERE n.x > {xMin}" +
                 "    AND n.x < {xMax}" +
                 "    AND n.y > {yMin}" +
                 "    AND n.y < {yMax}" +
                 "  RETURN n AS neighbour";

ExecutionResult result = engine.execute (query,
          map("xMin",xmMin,"xMax",xMax,"yMin",yMin,"yMax",yMax)); // query + params