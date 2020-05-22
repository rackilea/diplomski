StringBuilder script = new StringBuilder("insert into table1 values ");
    while (rs.next()) {
        script.append("(")
              .append(rs.getInt(1)).append(", '")
              .append(rs.getString(2)).append("', '")
              .append(rs.getString(3)).append("'")
          .append("),");
    }

script.setLength(script.length() - 1); //to remove the last comma.

String query = script.toString();