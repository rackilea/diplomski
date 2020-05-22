PreparedStatement ps1 = connection.prepareStatement
      ("SET @r=0");
ps1.ExecuteQuery();

PreparedStatement ps2 = connection.prepareStatement
      ("UPDATE `hg_stats` SET `stats_rank`= @r:= (@r+1) ORDER BY `stats_score` DESC");
ps2.ExecuteQuery();