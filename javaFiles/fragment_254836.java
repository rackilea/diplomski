private int[][] grid; // Your array of size ROWS x COLUMNS
private final int ROWS = 6, COLUMNS = 6;
private final int CONSECUTIVE_CONNECTION_REQUIRED = 3;

// Returns true if given playerType is forming a connection, else false.
public boolean checkGrid(int playerType)
{
  // Check downward
  for (int i = 0; i <= ROWS - CONSECUTIVE_CONNECTION_REQUIRED; i++)
  {
    for (int j = 0; j < COLUMNS; j++)
    {
      int counter = 0;
      for (int k = i; k < CONSECUTIVE_CONNECTION_REQUIRED + i; k++)
      {
        if (grid[k][j] == playerType)
          counter++;
      }

      if (counter == CONSECUTIVE_CONNECTION_REQUIRED)
        return true;
    }
  }

  // Check across
  for (int i = 0; i <= COLUMNS - CONSECUTIVE_CONNECTION_REQUIRED; i++)
  {
    for (int j = 0; j < ROWS; j++)
    {
      int counter = 0;
      for (int k = i; k < CONSECUTIVE_CONNECTION_REQUIRED + i; k++)
      {
        if (grid[j][k] == playerType)
          counter++;
      }

      if (counter == CONSECUTIVE_CONNECTION_REQUIRED)
        return true;
    }
  }

  // Check left to right diagonally
  for (int i = 0; i <= ROWS - CONSECUTIVE_CONNECTION_REQUIRED; i++)
  {
    for (int j = 0; j <= COLUMNS - CONSECUTIVE_CONNECTION_REQUIRED; j++)
    {
      int counter = 0;
      for (int k = i, m = j; k < CONSECUTIVE_CONNECTION_REQUIRED + i; k++, m++)
      {
        if (grid[k][m] == playerType)
          counter++;
      }

      if (counter == CONSECUTIVE_CONNECTION_REQUIRED)
        return true;
    }
  }

  // Check right to left diagonally
  for (int i = 0; i <= ROWS - CONSECUTIVE_CONNECTION_REQUIRED; i++)
  {
    for (int j = COLUMNS - 1; j >= COLUMNS - CONSECUTIVE_CONNECTION_REQUIRED; j--)
    {
      int counter = 0;
      for (int k = i, m = j; k < CONSECUTIVE_CONNECTION_REQUIRED + i; k++, m--)
      {
        if (grid[k][m] == playerType)
          counter++;
      }

      if (counter == CONSECUTIVE_CONNECTION_REQUIRED)
        return true;
    }
  }

  return false;
}