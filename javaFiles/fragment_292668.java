if( list.get(middle).getLastName.equals(searchLastName) )
        return middle;
else if( list.get(middle).getLastName.compareTo(searchLastName) >= 0 )
        return binarySearch(list, middle + 1, lastElem, searchLastName);
else
        return binarySearch(list, firstElem, middle - 1, searchLastName);
}