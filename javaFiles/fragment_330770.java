class Building;
class Space;
class Floor;

class Building
{
   int number_of_floors;
   vector<Floor*> _floors;  // list of floors in the building

   // building specific data
   string name;
   string address;
};

class Floor
{
   Building* pBuilding; // building for which this floor belongs
   int floor_number;    // the floor number (e.g 1-99)
   vector<Space*>; // list of spaces on this floor
}; 


class Space
{
public:
    enum SpaceType
    {
        Apartment,
        Store,
        Office
    };

private:
    SpaceType _spacetype;
    Floor* pFloor;   // floor in which this space exists on
};