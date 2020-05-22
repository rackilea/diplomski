String sql = "SELECT Expr1001" +
              " FROM (SELECT GameInfo.mapname" +
                          ", SUM(IIF(Map = GameInfo.mapname,1,0))" +
                      " FROM (SELECT *" +
                              " FROM [Character]" +
                             " INNER JOIN Player ON Character.PlayerID=Player.[ID]" +
                            ")  AS A" +
                     " RIGHT JOIN GameInfo ON A.Character.map = GameInfo.mapname" +
                     " GROUP BY GameInfo.mapname" +
                    ")  AS [%$##@_Alias]";