s = ("insert into " + this.database + ".user (nickname) values (?)");
      this.preparedStatement = this.connect.prepareStatement(s);
      for (String key : this.map.keySet())
        {
            this.preparedStatement.setString(1, key);
            this.preparedStatement.addBatch();
        }
        this.preparedStatement.executeBatch();