public enum Direction
        {
            NORTH = 0,
            EAST = 1,
            SOUTH = 2,
            WEST = 3
        }

        private static Dictionary<int, Direction> map = new Dictionary<int, Direction>();

        private static void PortJavaCodeToCSharp()
        {
            foreach (var directionName in Enum.GetValues(typeof(Direction)))
            {
                map.Add((int)directionName, (Direction)directionName);
            }    
        }