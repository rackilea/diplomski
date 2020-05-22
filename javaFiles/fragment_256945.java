String query = "SELECT 
                   H.Name as Name,
                   R.RacesWon as Race 
                 FROM Conditions as C
                 inner join Races AS R on C.ID = R.ConditionID
                 inner join Horses AS H on R.HorseID = H.ID";