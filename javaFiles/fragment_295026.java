for each city
{
    settled = false
    distance = infinity
}

startingCity.distance = 0

currentCity = startingCity

while not all cities are settled
{
    for each city adjacent to the current city
    {
        newDist = distance from adjacentCity to currentCity

        if newDist < adjacentCity.distance
        {
            adjacentCity.distance = newDist
        }  
    }

    currentCity.settled = true

    currentCity = city closest to currentCity
}