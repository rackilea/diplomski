if (searchMaze(left_from_start_point, end_point, maze))
  return true;
if (searchMaze(right_from_start_point, end_point, maze))
  return true;
if (searchMaze(above_start_point, end_point, maze))
  return true;
if (searchMaze(below_start_point, end_point, maze))
  return true;