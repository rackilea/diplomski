if( list.get(middle).getLastName().equals(searchLastName) )
        return middle; //should be ideally a getter for lastName
else if( list.get(middle).getLastName().compareTo(searchLastName) >0 ) //equals already checked, not requied here
        return binarySearch(list, middle + 1, lastElem, searchLastName);
else
        return binarySearch(list, firstElem, middle - 1, searchLastName);
}