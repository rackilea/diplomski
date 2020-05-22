if(sortDirection.equalsIgnoreCase("DESC")) {
        whereBuilder.append("DESC");
    } else if (sortDirection.equalsIgnoreCase("ASC")) {
        whereBuilder.append("ASC");
    } else {
        throw new ServiceException("Invalid Request: bad sort direction - "+sortDirection);
    }