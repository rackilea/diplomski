const unsigned bytes_per_row = 64U; // You need to change this according to the bitmask size.
const unsigned row_quantity = 32;   // Change per bitmask dimensions.
typedef std::pair<unsigned int, unsigned int> Location;
typedef std::vector<Location> Location_Container;
Location_Container text_locations;
uint8_t const * p_bitmask; // This needs to point to the first byte in the bitmask.
for (unsigned int row = 0; row < row_quantity; ++row)
{
    for (unsigned int column = 0; column < bytes_per_row; ++column)
    {
        uint8_t byte = *p_bitmask++; // Get byte from bitmask
        if (byte == 255)
        {
            Location l = Location(row, column);
            text_locations.push_back(location);
        }
    }
}
// At this point the vector text_locations contains the coordinates of
//    all the values of 255 in the bitmask.