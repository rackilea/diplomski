const int // these constants indicate which directions of travel are possible from a node
N = (1 << 0),       // travel NORTH from node is possible
S = (1 << 1),       // travel SOUTH from node is possible
E = (1 << 2),       // travel EAST  from node is possible
W = (1 << 3),       // travel WEST  from node is possible
NUM_DIRECTIONS = 4; // number of directions (might not be 4.  no reason it has to be)

const int
START  = (1 << 4),  // starting  node
FINISH = (1 << 5);  // finishing node

const int
MAZE_X = 4,         // maze dimensions
MAZE_Y = 4;

int maze[MAZE_X][MAZE_Y] = 
{
    {E,        S|E|W,    S|E|W,    S|W       },
    {S|FINISH, N|S,      N|START,  N|S       },
    {N|S,      N|E,      S|E|W,    N|S|W     },
    {N|E,      E|W,      N|W,      N         }
};

Node start  = {1, 2}; // position of start node
Node finish = {1, 0}; // position of end node