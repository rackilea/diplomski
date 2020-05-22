Given text query =
    """
 {
                Results: getSearchResults(searchLatitude:"<searchLatitude>", 
searchLongitude: "<searchLongitude>", providerType: "Primary Care Physicians", 
sortBy: "distance", maxDistance:"600",skip: 0, take: 10) {
                    providerID
                    firstName 
                    lastName
                    mI
                    title
                    name
                    nameLFMT
                    status
                    specialties
                    locations
                    institutions
                    acceptNewPatient
                    imageUri
                    distanceToNearest
                }

} 

    """
* replace query.searchLatitude = '38.942833'
* replace query.searchLongitude = '-119.984549'