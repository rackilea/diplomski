while (rs.next())
      {

        // get the column values; column indices start from 1
        for (int i = 1; i < count + 1; ++i)
        {
          String value = rs.getString(i);
          bufferField(value, i == count, buffer);
        }
      }